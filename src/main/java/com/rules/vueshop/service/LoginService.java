package com.rules.vueshop.service;

import com.rules.vueshop.dto.UserDTO;

import java.util.Map;

public interface LoginService {
    /**
     * 注册
     * @param userDTO 用户
     * @return 用户信息
     */
    Map<String, Object> register(UserDTO userDTO);

    /**
     * 登录
     * @param userDTO 用户
     * @return 用户信息
     */
    Map<String, Object> login(UserDTO userDTO);
}
