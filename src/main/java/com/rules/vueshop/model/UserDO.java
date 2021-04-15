package com.rules.vueshop.model;

import lombok.Data;

@Data
public class UserDO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;
}
