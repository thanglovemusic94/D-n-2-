package com.example.demo.util;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;

public class Converter {

    public static UserDTO convertToDTO(UserEntity userEntity) {
        UserDTO dto = new UserDTO();
        dto.setId(userEntity.getId());
        dto.setUsername(userEntity.getUsername());
        dto.setAvatar(userEntity.getAvatar());
        return dto;
    }

    public static UserEntity convertToEntity(UserDTO userDTO) {
        UserEntity entity = new UserEntity();
        entity.setUsername(userDTO.getUsername());
        entity.setAvatar(userDTO.getAvatar());
        return entity;
    }

}
