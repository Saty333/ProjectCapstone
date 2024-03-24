package com.capstoneproject.productservice.controllers;

import com.capstoneproject.productservice.models.Product;
import com.capstoneproject.productservice.services.FakeStoreProductService;
import com.capstoneproject.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private FakeStoreProductService productService;
    @Autowired
    public ProductController(FakeStoreProductService productService){
        this.productService = productService;
    }

//    API 1 (GET): getAllProducts
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

//    API 2 (GET): getSingleProduct
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

//    API 3 (POST): addNewProduct
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        Product product1 = new Product();
        product1.setTitle(product.getTitle());
        product1.setPrice(175.55);
        return product1;
    }

//    API 4 (PATCH): updateProduct
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

//    API 5 (PUT): replaceProduct
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

//    API 6 (DELETE): deleteProduct
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
}
