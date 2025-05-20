package com.iptracer.iptracer.config;

import jakarta.annotation.PostConstruct;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
public class RedisTest {

    private final RedissonClient redissonClient;

    public RedisTest(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @PostConstruct
    public void test() {
        redissonClient.getBucket("hello").set("world");
        System.out.println("🔁 Redis esta funcionando: " + redissonClient.getBucket("hello").get());
    }
}