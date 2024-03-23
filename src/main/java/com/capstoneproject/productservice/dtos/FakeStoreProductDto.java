package com.capstoneproject.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
//    This is a FakeStoreProductDto
//    Dto is created because when we use third party apis, we get response in their format
//    We call it Dto
//    This may differ from the response that we use at our end
//    So to cater the differences we create Dto for all 3rd party Api
//    An example is category in FakeStore api response is of type String
//    Whereas in our code we have kept it as class. Its id is of type Long
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}