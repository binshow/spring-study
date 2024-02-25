package com.binshow._102springbootjdbc.dao.impl;

import com.binshow._102springbootjdbc.bean.User;
import com.binshow._102springbootjdbc.dao.UserDao;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        String sql = "select * from t_user where id = ?";

        // 写法一：自己封装 rowMapper
//        return jdbcTemplate.queryForObject(sql , (rs,rowNum) -> {
//           // 从结果集取数据进行对象封装
//           User user = new User();
//           user.setId(id);
//           user.setLoginName(rs.getString("login_name"));
//           user.setNickName(rs.getString("nick_name"));
//           user.setPasswd(rs.getString("passwd"));
//           return user;
//       }, 1);

        // 写法二：使用封装好的 BeanPropertyRowMapper 实现类
        return jdbcTemplate.queryForObject(sql , new BeanPropertyRowMapper<>(User.class),1);
    }
}
