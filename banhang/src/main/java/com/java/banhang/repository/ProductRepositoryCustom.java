package com.java.banhang.repository;

import com.java.banhang.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductRepositoryCustom {
    Page<ProductEntity> getAllWithPageAndSize(int page, int size);
}
