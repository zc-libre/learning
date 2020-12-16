package com.zc.order.controller;

import com.zc.order.entity.Order;
import com.zc.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhao.cheng
 */
@Slf4j
@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/create")
    public void create(@RequestBody Order order) {
        log.info("请求订单微服务：{}",order.toString());
        orderService.create(order);
    }
}
