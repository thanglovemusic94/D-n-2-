package com.example.restuploadfile.util;


import com.example.restuploadfile.dto.UserDTO;
import com.example.restuploadfile.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class Converter {
    public  UserDTO toDTO(UserEntity userEntity) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO dto = modelMapper.map(userEntity, UserDTO.class);
        return dto;
    }

    public  UserEntity toEntity(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
        return entity;
    }

}
