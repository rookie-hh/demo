package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // 可以添加自定义查询方法
    // List<Product> findByPriceLessThan(BigDecimal price);
}