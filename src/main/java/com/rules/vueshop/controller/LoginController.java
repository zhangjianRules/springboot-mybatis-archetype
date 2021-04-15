package com.rules.vueshop.controller;

import com.rules.vueshop.common.Result;
import com.rules.vueshop.common.ResultGenerator;
import com.rules.vueshop.dto.UserDTO;
import com.rules.vueshop.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录相关接口", value = "登录相关接口")
@RequestMapping("/v1")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation("注册")
    @PostMapping(value = "/register")
    public Result<UserDTO> register(@RequestBody UserDTO userDTO) {
        return ResultGenerator.genSuccessResult(loginService.register(userDTO));
    }

    @ApiOperation("登录")
    @PostMapping(value = "/login")
    public Result<UserDTO> login(@RequestBody UserDTO userDTO) {
        return ResultGenerator.genSuccessResult(loginService.login(userDTO));
    }
}
