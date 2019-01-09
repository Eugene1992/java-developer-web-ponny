package com.cbsystematics.edu.internet_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "p_products")
public class Product extends AbstractEntity {

    private String title;

    private String description;

    private String category;

    private Integer price;


    public Product(Integer id, String title, String description, String category, Integer price) {
        this.id = id;
        this.version = 0;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
    }
}
