package org.binshow.dao;


import lombok.Data;

@Data
public class Order {

    private Integer orderId;
    private String orderName;
    private Integer customerId;


    private Customer customer;  // 一对一
}
