package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(
            UserRepository userRepo,
            ProductRepository productRepo,
            CartRepository cartRepo
    ) {
        return args -> {
            // 1. 创建测试用户（如果不存在）
            if (!userRepo.findByUsername("testuser").isPresent()) {
                User user = new User();
                user.setUsername("testuser");
                user.setPassword("123");
                user.setEmail("test@example.com");
                user.setCreatedAt(LocalDateTime.now());
                userRepo.save(user);
            }

            // 2. 创建测试商品
            Product product = new Product();
            product.setName("智能手机");
            product.setPrice(new BigDecimal("5999.00"));
            product.setDescription("旗舰级配置");
            product.setImageUrl("phone.jpg");
            productRepo.save(product);

            // 获取或创建用户
            User user = userRepo.findByUsername("testuser")
                    .orElseThrow(() -> new RuntimeException("用户不存在"));

            // 3. 创建购物车项
            CartItem item = new CartItem();
            item.setUser(user);
            item.setProduct(product);
            item.setQuantity(1);
            cartRepo.save(item);
        };
    }
}