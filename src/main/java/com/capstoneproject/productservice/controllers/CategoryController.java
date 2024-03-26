package com.capstoneproject.productservice.controllers;

import com.capstoneproject.productservice.services.FakeStoreCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class CategoryController {
    FakeStoreCategoryService categoryService;

//    API 1: Get all categories
    @GetMapping("categories")
    public List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }
}