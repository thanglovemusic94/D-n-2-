package com.java.banhang.repository;

import com.java.banhang.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByTensanpham(String tensanpham);
    List<ProductEntity> getAll(Pageable pageable);
}
