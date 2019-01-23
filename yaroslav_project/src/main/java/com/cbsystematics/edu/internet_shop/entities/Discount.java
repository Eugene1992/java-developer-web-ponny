package com.cbsystematics.edu.internet_shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "shop_discounts")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Discount extends AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "amount", nullable = false)
    private double amount;


    @ManyToMany(mappedBy = "discounts")
    private Collection<Product> products;


    public Discount(Integer id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Discount(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
}
