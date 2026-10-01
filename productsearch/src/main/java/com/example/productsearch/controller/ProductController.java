package com.example.productsearch.controller;

import com.example.productsearch.model.Product;
import com.example.productsearch.repository.ProductRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1️⃣ Get products by category (case-insensitive)
    // GET /products/category/Electronics
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }

    // 2️⃣ Filter products within price range
    // GET /products/filter?min=1000&max=50000
    @GetMapping("/filter")
    public List<Product> filterByPrice(
            @RequestParam double min,
            @RequestParam double max) {

        return productRepository.findByPriceBetween(min, max);
    }

    // 3️⃣ Get products sorted by price (JPQL Demo)
    // GET /products/sorted
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return productRepository.findAllSortedByPriceJPQL();
    }

    // 4️⃣ Get products above a certain price
    // GET /products/expensive/20000
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    // 5️⃣ Debug: Get all products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 6️⃣ Count products
    @GetMapping("/count")
    public long count() {
        return productRepository.count();
    }
}