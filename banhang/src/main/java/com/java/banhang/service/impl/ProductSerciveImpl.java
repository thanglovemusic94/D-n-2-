package com.java.banhang.service.impl;


import com.java.banhang.dto.PageResponse;
import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import com.java.banhang.repository.ProductRepository;
import com.java.banhang.service.ProductSercive;
import com.java.banhang.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSerciveImpl implements ProductSercive {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Converter converter;


    @Override
    public PageResponse<ProductDTO> findAll(int page , int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductEntity> content = productRepository.findAll(pageable);

        List<ProductDTO> ListDTO = new ArrayList<>();
        for (ProductEntity entity: content.getContent()) {
            ListDTO.add(converter.toDTO(entity));
        }
      return new PageResponse<>(ListDTO, content.getTotalPages(), content.getTotalElements(), content.getNumber(), content.getSize());
    }


    @Override
    public PageResponse<ProductDTO> findAllByTensanphamContaining(String tensanpham, int page , int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductEntity> content = productRepository.findAllByTensanphamContaining(tensanpham,pageable);
        List<ProductDTO> ListDTO = new ArrayList<>();
        for (ProductEntity entity: content.getContent()) {
            ListDTO.add(converter.toDTO(entity));
        }
        return new PageResponse<>(ListDTO, content.getTotalPages(), content.getTotalElements(), content.getNumber(), content.getSize());
    }


    @Override
    public Optional<ProductDTO> findById(int id) {
        ProductEntity ProductEntity = productRepository.findById(id).get();
        ProductDTO ProductDTO = converter.toDTO(ProductEntity);

        return Optional.ofNullable(ProductDTO);
    }



    @Override
    public ProductDTO save(ProductDTO ProductDTO) {
        ProductEntity ProductEntity = converter.toEntity(ProductDTO);
        productRepository.save(ProductEntity);
        ProductDTO.setId(ProductEntity.getId());
        return ProductDTO;
    }

    @Override
    public void deleteList(List<String> ids) {
        for (String id : ids) {
            productRepository.deleteById(Integer.valueOf(id));
        }
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
