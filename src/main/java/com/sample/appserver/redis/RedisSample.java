package com.sample.appserver.redis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by satoshi on 2018/01/22.
 */
@Component
public class RedisSample {

  private static final Logger LOGGER = LoggerFactory.getLogger(RedisSample.class);

  @Autowired
  private StringRedisTemplate redisTemplate;

  public void put(String key, String value, Long expiresIn) {
    redisTemplate.opsForValue().set(key, value);
    redisTemplate.expire(key, expiresIn, TimeUnit.SECONDS);
    LOGGER.info("saved. key:{} value:{}", key, value);
  }

  public String get(String key) {
    return redisTemplate.opsForValue().get(key);
  }
}
