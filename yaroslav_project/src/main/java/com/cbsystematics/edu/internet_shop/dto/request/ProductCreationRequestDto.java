package com.cbsystematics.edu.internet_shop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreationRequestDto {

    private String title;
    private String description;
    private Integer price;
    private String category;
    private String imgUrl;

}
