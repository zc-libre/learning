package com.zc.account.service;

import java.math.BigDecimal;

/**
 * @author zhao.cheng
 * @date 2020/12/15 11:57
 */
public interface AccountService {

     void decrease(Long userId, BigDecimal money);
}
