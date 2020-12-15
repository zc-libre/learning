package com.zc.account.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zc.account.entity.Account;
import com.zc.account.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author zhao.cheng
 * @date 2020/12/15 14:32
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void decrease(Long userId, BigDecimal money) {
        Account account = accountMapper.selectOne(Wrappers.<Account>lambdaQuery().eq(Account::getUserId, userId));

        account.setUsed(account.getUsed().add(money));
        account.setResidue(account.getResidue().subtract(money));
        accountMapper.updateById(account);
        int i = 10/ 0;
    }
}
