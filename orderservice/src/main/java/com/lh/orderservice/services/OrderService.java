package com.lh.orderservice.services;


import com.lh.feign.pojo.OrderInfo;

public interface OrderService {

    OrderInfo selectOrderInfo(Integer id);
}
