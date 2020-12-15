package com.zc.order.service;

import com.zc.order.entity.Order;

/**
 * @author zhao.cheng
 * @date 2020/12/15 11:51
 */
public interface OrderService {

     /**
      * 创建订单
      * @param order /
      */
     void create(Order order);
}
