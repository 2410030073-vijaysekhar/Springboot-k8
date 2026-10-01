package com.klu.ecommerce.service;

import com.klu.ecommerce.model.Product;
import com.klu.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product p) {
        return repo.save(p);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product p) {
        Product existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(p.getName());
            existing.setPrice(p.getPrice());
            existing.setQuantity(p.getQuantity());
            existing.setImageUrl(p.getImageUrl());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}