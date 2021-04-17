package com.rules.vueshop.service.impl;

import com.rules.vueshop.dto.UserDTO;
import com.rules.vueshop.exceptions.HintException;
import com.rules.vueshop.mapper.UserMapper;
import com.rules.vueshop.model.UserDO;
import com.rules.vueshop.service.LoginService;
import com.rules.vueshop.util.DataMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO register(UserDTO addUserDTO) {
        UserDTO userDTO = Optional.ofNullable(addUserDTO.getUsername()).map(i -> userMapper.queryUser(i)).map(DataMapperUtil::mapUserDO).orElseThrow(() -> new HintException("用户名不存在" + addUserDTO.getUsername()));
        return null;
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        return Optional.ofNullable(userDTO.getUsername()).map(i ->userMapper.queryUser(i)).map(DataMapperUtil::mapUserDO).orElseThrow(() -> new HintException("用户名不存在" + userDTO.getUsername()));
    }
}
