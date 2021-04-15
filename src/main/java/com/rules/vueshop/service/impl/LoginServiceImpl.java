package com.rules.vueshop.service.impl;

import com.rules.vueshop.dto.UserDTO;
import com.rules.vueshop.exceptions.HintException;
import com.rules.vueshop.mapper.UserMapper;
import com.rules.vueshop.model.UserDO;
import com.rules.vueshop.service.LoginService;
import com.rules.vueshop.util.DataMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO register(UserDTO addUserDTO) {
        UserDTO userDTO = Optional.ofNullable(addUserDTO.getUsername()).map(i -> userMapper.queryUser(i)).map(DataMapperUtil::mapUserDO).orElseThrow(() -> new HintException("用户名不能为空"));
        return null;
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        return null;
    }
}
