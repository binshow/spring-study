package com.binshow._103springbootmybatis.mapper;

import com.binshow._103springbootmybatis.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    // todo  1. 每个方法都在Mapper文件中有一个sql标签对应
    // 2. 所有参数都要用 @Param 进行签名
    User getUserById(@Param("id") long id);
}
