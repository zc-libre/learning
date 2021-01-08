package com.zc.order.service;

import com.zc.order.entity.Order;
import com.zc.order.feign.AccountClient;
import com.zc.order.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

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
    private final AccountClient accountClient;


    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("下单开始, xid: {}", RootContext.getXID());
        orderMapper.insert(order);

        //远程调用账户服务扣减余额
        log.info("===============>扣减余额开始");
        accountClient.decrease(order.getUserId(),order.getMoney());

        //修改订单状态为已完成
        log.info("===============>修改订单状态");
        order.setStatus(1);
        orderMapper.updateById(order);
        log.info("===============>修改订单状态结束");

    }
}
