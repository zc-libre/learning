package com.zc.account.controller;

import com.zc.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zhao.cheng
 * @date 2020/12/15 14:45
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/decrease")
    public void decrease (Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
    }
}
