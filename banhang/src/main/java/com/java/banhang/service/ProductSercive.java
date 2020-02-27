package com.java.banhang.service;

import com.java.banhang.dto.PageResponse;
import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductSercive {
    List<ProductEntity> getAll(int page, int size);;
    Optional<ProductDTO> findById(int id);
    Optional<ProductDTO> findByTensanpham(String username);
    ProductDTO save(ProductDTO UserDTO);
    void deleteAll(List<String> ids);
}
