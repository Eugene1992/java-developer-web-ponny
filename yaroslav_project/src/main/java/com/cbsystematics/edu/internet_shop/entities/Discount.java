package com.cbsystematics.edu.internet_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount extends AbstractEntity {

    private String name;
    private double amount;

    public Discount(Integer id, String name, double amount) {
        this.id = id;
        this.version = 0;
        this.name = name;
        this.amount = amount;
    }
}
