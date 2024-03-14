package org.binshow.mapper;

import org.apache.ibatis.annotations.Param;
import org.binshow.dao.User;

public interface UserMapper {

    /**
     * 全部用插件生成
     *
     * @param id
     * @return
     */
    public User queryUserById(@Param("id") Long id);
}
