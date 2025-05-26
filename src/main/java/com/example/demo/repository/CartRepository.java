// src/main/java/com/example/demo/repository/CartRepository.java
package com.example.demo.repository;

import com.example.demo.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    // 自定义查询方法
    List<CartItem> findByUserId(Long userId);
}