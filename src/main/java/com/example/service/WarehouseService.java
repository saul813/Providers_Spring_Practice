package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseService {

    private final ProductRepository productRepository;

    public WarehouseService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional //Ensures atomicity. If a crash happens midway, everything drops back
    public void setupInventoryBatch() {
        productRepository.createTable();

        productRepository.save(new Product(1, "Premium Mechanical Keyboard", 50));
        System.out.println("First record saved securely...");

        // Simulate an intentional runtime failure (e.g. system disconnect or unique key violation)
        if (true) {
            throw new RuntimeException("CRITICAL FAULT: Simulating immediate database crash scenario!");
        }

        // This operation will never execute, causing the first saved record to be rolled back completely
        productRepository.save(new Product(2, "Wireless Ergonomic Mouse", 120));
    }
}
