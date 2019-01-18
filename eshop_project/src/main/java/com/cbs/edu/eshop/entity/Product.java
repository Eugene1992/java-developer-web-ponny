package com.cbs.edu.eshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "eshop_products")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column
    private Integer price;
}
