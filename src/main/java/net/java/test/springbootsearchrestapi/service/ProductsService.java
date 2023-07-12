package net.java.test.springbootsearchrestapi.service;

import java.util.List;
import java.util.Map;

import domain.CustomJoin;
import net.java.test.springbootsearchrestapi.entity.Products;

public interface ProductsService {
    List<Products> readProducts();

    List<Products> readProductsById(String id);

    Map<String, String> deleteProductsById(String id);

    Map<String, String> updateProductsById(String id, Products products);

    Map<String, String> createProducts(Products products);

    List<Map<String, String>> postReadProducts2(Products products);

    List<Map<String,String>> customFind(Products products);
}
