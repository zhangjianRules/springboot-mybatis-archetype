package com.rules.vueshop.mapper;

import com.rules.vueshop.model.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    UserDO queryUser(@Param("username") String username);

    /**
     * 新增用户信息
     * @param userDO 用户信息
     * @return 用户信息
     */
    UserDO upsertUser(@Param("userDO") UserDO userDO);
}
