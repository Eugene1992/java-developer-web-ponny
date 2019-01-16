package com.cbsystematics.edu.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany()
    @JoinTable(name = "categories_products",
            joinColumns = @JoinColumn(name = "categories_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;

    @ManyToMany()
    @JoinTable(name = "parent_child_categories",
            joinColumns = @JoinColumn(name = "parent_category"),
            inverseJoinColumns = @JoinColumn(name = "child_category"))
    private List<Category> parentCategory;

    @ManyToMany()
    @JoinTable(name = "parent_child_categories",
            joinColumns = @JoinColumn(name = "child_category"),
            inverseJoinColumns = @JoinColumn(name = "parent_category"))
    private List<Category> childCategory;


}
