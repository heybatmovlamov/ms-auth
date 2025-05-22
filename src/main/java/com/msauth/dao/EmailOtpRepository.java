package com.msauth.dao;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class EmailOtpRepository {

    private final RedisTemplate<String, String> redisTemplate;

    @Value("${application.cache.email-otp.prefix}")
    private String prefix;

    @Value("${application.cache.email-otp.ttl}")
    private long ttl;

    public EmailOtpRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, String otp) {
        key = buildKey(key);

        redisTemplate.opsForValue().set(key, otp);
        redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
    }

    public String read(String key) {
        return redisTemplate.opsForValue().get(buildKey(key));
    }

    public void delete(String key) {
        redisTemplate.delete(buildKey(key));
    }

    public Long getExpireTime(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(buildKey(key), timeUnit);
    }

    private String buildKey(String key) {
        return String.format("%s_%s", prefix, key.toLowerCase());
    }

}
