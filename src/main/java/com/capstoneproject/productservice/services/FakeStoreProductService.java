package com.capstoneproject.productservice.services;

import com.capstoneproject.productservice.dtos.FakeStoreProductDto;
import com.capstoneproject.productservice.models.Category;
import com.capstoneproject.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@Service annotation tells Spring that it is an important class
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id){

//        Below Code in Block <B1> basically means that hey Rest Controller, make a Get Request to Url and
//        you will get response in for of dataType FakeStoreProductDto
//        <B1>
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );
//        </B1>

//        Since the response of 3rd Party Api is in different format as what is expected from this Method
//        So we will write a function to convert the response in desired format.
        return convertFakeStoreProductToProduct(productDto);

    }
    private Product convertFakeStoreProductToProduct(FakeStoreProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(dto.getCategory());
        return product;
    };
}