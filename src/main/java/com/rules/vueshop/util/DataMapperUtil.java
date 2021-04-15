package com.rules.vueshop.util;

import com.rules.vueshop.dto.UserDTO;
import com.rules.vueshop.model.UserDO;

import java.util.Optional;

public class DataMapperUtil {
    public static UserDTO mapUserDO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        Optional.ofNullable(userDO.getUsername()).ifPresent(userDTO::setUsername);
        Optional.ofNullable(userDO.getEmail()).ifPresent(userDTO::setEmail);
        Optional.ofNullable(userDO.getPassword()).ifPresent(userDTO::setPassword);
        Optional.ofNullable(userDO.getPhone()).ifPresent(userDTO::setPhone);
        return userDTO;
    }

    public static UserDO mapUserDTO(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        Optional.ofNullable(userDTO.getUsername()).ifPresent(userDO::setUsername);
        Optional.ofNullable(userDTO.getEmail()).ifPresent(userDO::setEmail);
        Optional.ofNullable(userDTO.getPassword()).ifPresent(userDO::setPassword);
        Optional.ofNullable(userDTO.getPhone()).ifPresent(userDO::setPhone);
        return userDO;
    }
}
