package org.binshow.dao;

import lombok.Data;

import java.util.List;

/**
 * 客户实体类
 */


@Data
public class Customer {

    private Integer customerId;
    private String customerName;


    // 一对多
    private List<Order> orderList;
}
