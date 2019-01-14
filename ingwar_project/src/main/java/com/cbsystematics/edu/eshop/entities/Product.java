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
@Table(name = "products")
public class Product extends AbstractEntity{
    private String serial;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

    @OneToMany
    @JoinColumn(name = "discounts_id")
    private List<Discount> discounts;
}
