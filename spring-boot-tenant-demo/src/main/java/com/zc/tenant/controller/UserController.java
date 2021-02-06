package com.zc.tenant.controller;

import com.zc.tenant.entity.User;
import com.zc.tenant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhao.cheng
 * @date 2020/9/27 15:37
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.findAll();
    }

}
