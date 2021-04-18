package com.rules.vueshop.service.impl;

import com.rules.vueshop.dto.UserDTO;
import com.rules.vueshop.exceptions.HintException;
import com.rules.vueshop.mapper.UserMapper;
import com.rules.vueshop.model.UserDO;
import com.rules.vueshop.service.LoginService;
import com.rules.vueshop.util.DataMapperUtil;
import com.rules.vueshop.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Map<String, Object> register(UserDTO addUserDTO) {
        UserDTO userDTO = Optional.ofNullable(addUserDTO.getUsername()).map(i -> userMapper.queryUser(i)).map(DataMapperUtil::mapUserDO).orElse(null);
        if (Objects.nonNull(userDTO)) {
            throw new HintException("用户已存在: " + addUserDTO.getUsername());
        }
        UserDTO dto = new UserDTO();
        Optional.ofNullable(addUserDTO.getUsername()).ifPresent(dto::setUsername);
        Optional.ofNullable(addUserDTO.getPassword()).ifPresent(dto::setPassword);
        Optional.ofNullable(addUserDTO.getEmail()).ifPresent(dto::setEmail);
        Optional.ofNullable(addUserDTO.getPhone()).ifPresent(dto::setPhone);
        userMapper.upsertUser(DataMapperUtil.mapUserDTO(dto));
        return facadeTokenReturn(dto);
    }

    @Override
    public Map<String, Object> login(UserDTO loginUserDTO) {
        UserDTO userDTO = Optional.ofNullable(loginUserDTO.getUsername()).map(i -> userMapper.queryUser(i)).map(DataMapperUtil::mapUserDO).orElseThrow(() -> new HintException("用户名不存在" + loginUserDTO.getUsername()));
        return facadeTokenReturn(userDTO);
    }

    private Map<String, Object> facadeTokenReturn(UserDTO userDTO){
        Map<String, Object> result = new HashMap<>();
        result.put("token", tokenGenerator(userDTO));
        result.put("user", userDTO);
        return result;
    }

    private String tokenGenerator(UserDTO userDTO){
        Map<String, String> map = new HashMap<>();
        map.put("username", userDTO.getUsername());
        map.put("password", userDTO.getPassword());
        return TokenUtil.getToken(map);
    }
}
