package com.java.banhang.service;

import com.java.banhang.dto.PageResponse;
import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

public interface ProductSercive {

    PageResponse<ProductDTO> findAll(int page, int size);

    PageResponse<ProductDTO> findAllByTensanphamContaining(String tensanpham, int page, int size);

    Optional<ProductDTO> findById(int id);

    ProductDTO save(ProductDTO UserDTO) throws IOException;

    void deleteList(List<String> ids);

    void deleteAll();

    Resource getImage(String filename) throws MalformedURLException;
}
