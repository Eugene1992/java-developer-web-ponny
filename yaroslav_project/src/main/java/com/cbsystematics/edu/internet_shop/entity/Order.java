package com.cbsystematics.edu.internet_shop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "shop_orders")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Order extends AbstractEntity {

    @Column(name = "order_status", nullable = false, unique = true)
    private String orderStatus;


    @ManyToMany
    @JoinTable(name = "shop_orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
