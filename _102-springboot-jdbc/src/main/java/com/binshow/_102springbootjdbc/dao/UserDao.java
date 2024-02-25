package com.binshow._102springbootjdbc.dao;

import com.binshow._102springbootjdbc.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int add(User user);
    int update(User user);
    int deleteBysno(String sno);
    List<Map<String,Object>> queryUserListMap();

    User queryById(int id);
}
