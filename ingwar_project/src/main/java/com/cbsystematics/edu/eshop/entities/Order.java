package com.cbsystematics.edu.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{

    @Column(nullable = false)
    private String orderNumber;
    @Column(nullable = false)
    private Date orderDate;

    @OneToMany
    @JoinColumn(name = "products_id")
    private List<Product> products;
}
