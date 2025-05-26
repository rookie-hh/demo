// src/main/java/com/example/demo/model/CartItem.java
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity = 1;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}