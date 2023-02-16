package com.lh.orderservice.mapper;


import com.lh.feign.pojo.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    OrderInfo getOrderInfoById(Integer id);
}
