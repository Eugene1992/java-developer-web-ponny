package com.cbs.edu.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDTO {

    private String title;

    private String imgUrl;

    private String description;

    private String category;

    private String price;
}
