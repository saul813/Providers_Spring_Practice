package com.example.controller;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Maps web requests targetting http://localhost:8080/your-app-context/products
    @GetMapping("/products")
    public List<Product> fetchInventoryReports() {
        // Returns a raw Java list object, Spring MVC converts this into clean JSON automatically!
        return productRepository.findAll();
    }
}
