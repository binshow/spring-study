package org.binshow.mapper;


import org.binshow.dao.Order;

public interface OrderMapper {

    // 根据id查询订单信息和订单对应的客户信息

    Order queryOrderById(Integer id);
}
