package com.libre.security;

import com.libre.redis.cache.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Autowired
    private  RedisUtils redisUtils;
    @Test
    void contextLoads() {
        Dog dog = new Dog();
        dog.setId("a");
        dog.setName("b");
        redisUtils.set("a", dog);
    }

}
