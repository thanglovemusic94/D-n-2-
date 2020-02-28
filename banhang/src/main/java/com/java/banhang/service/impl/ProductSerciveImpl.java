package com.java.banhang.service.impl;


import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import com.java.banhang.repository.ProductRepository;
import com.java.banhang.service.ProductSercive;
import com.java.banhang.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSerciveImpl implements ProductSercive {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Converter converter;

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
      return productRepository.findAll(pageable);
    }

    @Override
    public Page<ProductEntity> findAllByTensanpham(String tensanpham, Pageable pageable) {
        return productRepository.findAllByTensanpham(tensanpham, pageable);
    }


    @Override
    public Optional<ProductDTO> findById(int id) {
        ProductEntity ProductEntity = productRepository.findById(id).get();
        ProductDTO ProductDTO = converter.toDTO(ProductEntity);
        return Optional.ofNullable(ProductDTO);
    }

    @Override
    public Optional<ProductDTO> findByTensanpham(String tensanpham) {
        ProductEntity ProductEntity = productRepository.findByTensanpham(tensanpham);
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
