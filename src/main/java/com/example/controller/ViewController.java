package com.example.controller;

import com.example.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // ✨ Returns a visual view page, not raw data
public class ViewController {

    private final ProductRepository productRepository;

    public ViewController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/inventory-ui")
    public String showInventoryPage(Model model) {
        // Send our database list to the HTML screen under the variable name "products"
        model.addAttribute("products", productRepository.findAll());

        return "inventory"; // Looks for a file named inventory.html
    }
}
