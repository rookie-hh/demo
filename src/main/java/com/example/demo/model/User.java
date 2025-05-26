// src/main/java/com/example/demo/model/User.java
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false) // 改为非空约束
    private String email = "default@example.com"; // 设置默认值

    private LocalDateTime createdAt;
}