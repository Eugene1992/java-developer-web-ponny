package com.cbsystematics.edu.internet_shop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "shop_products")
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

    @Column(name = "img_url", nullable = false)
    private String imgUrl;



    @ManyToMany
    @JoinTable(name = "shop_products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;


    @ManyToMany
    @JoinTable(name = "shop_products_discounts",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    private Set<Discount> discounts;


    public Product(String title, String description, String category, Integer price, String imgUrl) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Product(Integer id, String title, String description, String category, Integer price, String imgUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imgUrl = imgUrl;
    }


    public String getCategoriesNames() {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.joining(","));
    }


    @Override
    public String toString() {
        return "Product{"
                + "title='" + title + '\''
                + ", description='" + description + '\''
                + ", category='" + category + '\''
                + ", price=" + price
                + ", imgUrl='" + imgUrl + '\''
                + ", id=" + id
                + ", version=" + version
                + '}';
    }
}
