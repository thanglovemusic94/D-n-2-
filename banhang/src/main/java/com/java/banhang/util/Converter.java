package com.java.banhang.util;

import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("Converter")
public class Converter<T> {

    public ProductDTO toDTO(ProductEntity userEntity) {
        ModelMapper modelMapper = new ModelMapper();
        ProductDTO dto = modelMapper.map(userEntity, ProductDTO.class);
        return dto;
    }

    public ProductEntity toEntity(ProductDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ProductEntity entity = modelMapper.map(userDTO, ProductEntity.class);
        return entity;
    }
}
