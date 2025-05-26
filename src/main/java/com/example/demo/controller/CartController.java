// src/main/java/com/example/demo/controller/CartController.java
package com.example.demo.controller;

import com.example.demo.model.CartItem;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    @GetMapping
    public List<CartItem> getCart() {
        // 改为使用自定义查询方法（实际项目应该关联用户ID）
        return cartRepo.findAll(); // 现在这个方法可用了
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartRepo.save(item);
    }
}