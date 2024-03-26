package com.capstoneproject.productservice.services;

import com.capstoneproject.productservice.configs.ApplicationConfiguration;
import com.capstoneproject.productservice.dtos.FakeStoreCategoryDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private RestTemplate restTemplate;

    public FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<String> getAllCategories(){
        List<String> allCategories = new ArrayList<>();
        restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                List.class
        );

        return allCategories;
    }

    private List<String> convertFakeStoreCategoryToListOfCategory(List<String> str){
        for(FakeStoreCategoryDto dto:str){

        }
    }
}