package com.zc.tenant.service;

import com.zc.tenant.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zhao.cheng
 * @date 2020/9/27 15:33
 */
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    void findAll() {
        List<User> all = userService.findAll();
        all.forEach(System.out::println);
    }
}
