package com.iptracer.iptracer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Data
@AllArgsConstructor
@Service
public class RequestCoalescerService {

    private final RedissonClient redissonClient;
    private final ObjectMapper objectMapper;

    public HashMap<String,Object> coalesce(String ip, Supplier<Map<String,Object>> supplier){
        String resultKey = "ipinfo:result:" + ip;
        String lockKey = "ipinfo:lock:" + ip;

        RBucket<String> cache = redissonClient.getBucket(resultKey);
        String cachedResult = cache.get();

        if (cachedResult != null) {
            try {
                return objectMapper.readValue(cachedResult, new TypeReference<>() {});
            } catch (JsonProcessingException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Error leyendo resultado cacheado", e);
            }
        }

        RLock lock = redissonClient.getLock(lockKey);

        boolean acquired = false;
        try {
            acquired = lock.tryLock(10, 5, TimeUnit.SECONDS); // espera hasta 10s, lockea por 5s
            if (acquired) {
                // doble verificación: otra instancia pudo haber guardado ya el resultado
                String doubleCheck = cache.get();
                if (doubleCheck != null) {
                    return objectMapper.readValue(doubleCheck, new TypeReference<>() {});
                }

                Map<String, Object> result = supplier.get();
                cache.set(objectMapper.writeValueAsString(result), 60, TimeUnit.SECONDS); // TTL 1s
                return (HashMap<String, Object>) result;
            } else {
                throw new RuntimeException("No se pudo adquirir lock para IP: " + ip);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error en deduplicación distribuida", e);
        } finally {
            if (acquired ) {
                if(lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }

    }

}
