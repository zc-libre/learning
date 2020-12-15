package com.zc.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zhao.cheng
 * @date 2020/12/15 14:48
 */
@Component
@FeignClient(name = "seata-account-service")
public interface AccountService {

    @GetMapping("/account/decrease")
    void decrease (@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
