package com.cbsystematics.edu.internet_shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "eshop_products")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Product extends AbstractEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "price", nullable = false)
    private Integer price;



    @ManyToMany
    @JoinTable(name = "eshop_products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;


    @ManyToMany
    @JoinTable(name = "eshop_products_discounts",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    private Set<Discount> discounts;


    public Product(Integer id, String title, String description, String category, Integer price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Product(String title, String description, String category, Integer price) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
    }
}
