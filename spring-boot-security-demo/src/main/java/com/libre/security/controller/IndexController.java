package com.libre.security.controller;

import com.libre.core.result.R;
import com.libre.security.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author zhao.cheng
 * @date 2021/3/3 13:46
 */
@Api(tags = "首页")
@RestController
public class IndexController {

    @GetMapping("/")
    public R<User> index() {

        User user = new User();
        user.setId(1233333333333333334L);
        user.setName("wewfw efwefewfe");
        user.setDateTime(LocalDateTime.now());
        return R.data(user);
    }
}
