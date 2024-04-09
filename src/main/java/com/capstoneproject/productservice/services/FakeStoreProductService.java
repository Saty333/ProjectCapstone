package com.capstoneproject.productservice.services;

import com.capstoneproject.productservice.dtos.FakeStoreProductDto;
import com.capstoneproject.productservice.models.Category;
import com.capstoneproject.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
//                Below line tells that this url should be called for API
                "https://fakestoreapi.com/products/" + id,
//                Below line tells that object will be of data type FakeStoreProductDto. (FakeStoreProductDto is a class)
                FakeStoreProductDto.class
        );
//        </B1>

//        Since the response of 3rd Party Api is in different format as what is expected from this Method
//        So we will write a function to convert the response in desired format.
        return convertFakeStoreProductToProduct(productDto);

    }

    public List<Product> getAllProducts(){
//        Below code will not work due to type erasure
//        List<FakeStoreProductDto> response = restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                List<FakeStoreProductDto>.class
//        );

        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        List<Product> answer = new ArrayList<>();

        for (FakeStoreProductDto dto: response){
            answer.add(convertFakeStoreProductToProduct(dto));
        }
        return answer;
    }



    private List<Product> convertFakeStoreProductListToProductList(FakeStoreProductDto[] dto){
        List<Product> products = new ArrayList<>();

        // Iterate over each FakeStoreProductDto object in the list
        for (FakeStoreProductDto fakeStoreProductDto : dto) {
            // Call the conversion function and add the returned Product object to the list
            Product product = convertFakeStoreProductToProduct(fakeStoreProductDto);
            products.add(product);
        }
        return products;
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