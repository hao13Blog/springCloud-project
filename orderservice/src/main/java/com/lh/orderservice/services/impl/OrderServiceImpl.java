package com.lh.orderservice.services.impl;

import com.lh.feign.clients.UserClient;
import com.lh.feign.pojo.OrderInfo;
import com.lh.feign.pojo.User;

import com.lh.orderservice.mapper.OrderMapper;
import com.lh.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

   /* @Override
    public OrderInfo selectOrderInfo(Integer id) {
        OrderInfo orderInfo= orderMapper.getOrderInfoById(id);
        //String url = "http://127.0.0.1:8081/user/"+orderInfo.getId();
        String url = "http://userservice/user/"+orderInfo.getId();
        User user = restTemplate.getForObject(url,User.class);
        orderInfo.setUser(user);
        return orderInfo;
    }*/

    @Override
    public OrderInfo selectOrderInfo(Integer id) {
        OrderInfo orderInfo = orderMapper.getOrderInfoById(id);
        User user = userClient.findById(orderInfo.getId());
        orderInfo.setUser(user);
        return orderInfo;
    }
}
