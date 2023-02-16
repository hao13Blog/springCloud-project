package com.lh.orderservice.controller;


import com.lh.feign.pojo.OrderInfo;
import com.lh.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RefreshScope //nacos自动热更新
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${info.city}")
    private String city;

    @GetMapping("/hometown")
    public String hometown() {
        return "我的家乡是美丽的、" + "漂亮的" + city;
    }

    @RequestMapping(value = "/id")
    public OrderInfo getOrderInfo(@RequestParam("id") Integer id) {
        return orderService.selectOrderInfo(id);
    }
}
