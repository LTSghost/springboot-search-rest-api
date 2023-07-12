package net.java.test.springbootsearchrestapi.service;

import net.java.test.springbootsearchrestapi.entity.Product;
import net.java.test.springbootsearchrestapi.entity.Products;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
