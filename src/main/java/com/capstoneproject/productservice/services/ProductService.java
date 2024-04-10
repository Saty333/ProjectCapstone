package com.capstoneproject.productservice.services;

import com.capstoneproject.productservice.models.Product;

import java.util.List;

public interface ProductService{
    public Product getSingleProduct(Long id);
    List<Product> getAllProducts();
}