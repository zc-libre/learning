package com.zc.order.service;

import com.zc.account.entity.Account;
import com.zc.order.entity.Order;
import com.zc.order.feign.AccountService;
import com.zc.order.mapper.OrderMapper;
import com.zc.storage.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * 订单业务实现类
 *
 * @author zhao.cheng
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final AccountService accountService;


    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->下单开始");
     /*
        //远程调用库存服务扣减库存
        log.info("------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId());
        log.info("------->order-service中扣减库存结束:{}",order.getId());
*/

        log.info("xid: {}", RootContext.getXID());
        orderMapper.insert(order);

        //远程调用账户服务扣减余额
        log.info("------->order-service中扣减余额开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->order-service中扣减余额结束");

        //修改订单状态为已完成
        log.info("------->order-service中修改订单状态开始");
        order.setStatus(1);
        orderMapper.updateById(order);
        log.info("------->order-service中修改订单状态结束");

        log.info("------->下单结束");
    }
}
