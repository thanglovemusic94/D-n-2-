package com.java.banhang.service;

import com.java.banhang.dto.PageResponse;
import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductSercive {

    PageResponse<ProductDTO> findAll(int page, int size);

    PageResponse<ProductDTO> findAllByTensanphamContaining(String tensanpham, int page, int size);

    Optional<ProductDTO> findById(int id);

    ProductDTO save(ProductDTO UserDTO);

    void deleteList(List<String> ids);
    void deleteAll();
}
