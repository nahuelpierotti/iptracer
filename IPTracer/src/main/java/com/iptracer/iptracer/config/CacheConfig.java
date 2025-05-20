package com.iptracer.iptracer.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {



    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(10))  // caché por 10s
                .disableCachingNullValues();
    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        String redisHost = System.getenv().getOrDefault("SPRING_REDIS_HOST", "localhost");
        config.useSingleServer().setAddress("redis://" + redisHost + ":6379");
        return Redisson.create(config);
    }

}
