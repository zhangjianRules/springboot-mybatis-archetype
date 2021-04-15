package com.rules.vueshop.service;

import com.rules.vueshop.dto.UserDTO;

public interface LoginService {
    /**
     * 注册
     * @param userDTO 用户
     * @return 用户信息
     */
    UserDTO register(UserDTO userDTO);

    /**
     * 登录
     * @param userDTO 用户
     * @return 用户信息
     */
    UserDTO login(UserDTO userDTO);
}
