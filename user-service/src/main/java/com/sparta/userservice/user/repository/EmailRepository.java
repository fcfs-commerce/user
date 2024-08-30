package com.sparta.userservice.user.repository;

import com.sparta.userservice.global.redis.RedisRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository extends RedisRepository<String, String> {

  private static final String PREFIX = "EMAIL_CODE:";

  public EmailRepository(RedisTemplate<String, String> redisTemplate) {
    super(PREFIX, redisTemplate);
  }
}
