package org.binshow.mapper;

import org.binshow.dao.Customer;

import java.util.List;

public interface CustomerMapper {

    // 一对多需求
    // 查询所有客户信息及客户对应的订单信息

    List<Customer> queryList();
}
