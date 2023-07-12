package net.java.test.springbootsearchrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.test.springbootsearchrestapi.entity.Product;
import net.java.test.springbootsearchrestapi.repository.ProductRepository;
import net.java.test.springbootsearchrestapi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public List<Product> searchProducts(String query) {
       List<Product> products = productRepository.searchProducts(query);
       return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    
    
}
