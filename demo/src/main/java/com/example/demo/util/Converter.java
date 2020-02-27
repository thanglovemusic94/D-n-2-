package com.example.demo.util;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.modelmapper.ModelMapper;

public class Converter {

    public static UserDTO toDTO(UserEntity userEntity) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO dto = modelMapper.map(userEntity, UserDTO.class);
        return dto;
    }

    public static UserEntity toEntity(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
        return entity;
    }


}
