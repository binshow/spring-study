package com.binshow._102springbootjdbc.service.impl;

import com.binshow._102springbootjdbc.bean.User;
import com.binshow._102springbootjdbc.dao.UserDao;
import com.binshow._102springbootjdbc.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int deleteBysno(String sno) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> queryUserListMap() {
        return null;
    }

    @Override
    public User queryById(int id) {
        return userDao.queryById(id);
    }
}
