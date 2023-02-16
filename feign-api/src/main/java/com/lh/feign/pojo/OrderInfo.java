package com.lh.feign.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    /**
     * 订单id
     */
    private Long id;

    /**
     * 订单编号
     */
    private String num;

    /**
     * 开单日期
     */
    private Date date;

    /**
     * 用户信息
     */
    private User user;
}
