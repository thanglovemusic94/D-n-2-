package com.java.banhang.repository;

import com.java.banhang.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>, ProductRepositoryCustom {
    ProductEntity findByTensanpham(String tensanpham);
    Page<ProductEntity> findAll(Pageable pageable);
    Page<ProductEntity> findAllByTensanphamContaining(String tensanpham, Pageable pageable);

}
