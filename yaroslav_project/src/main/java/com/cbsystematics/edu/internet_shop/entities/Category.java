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
@Table(name = "shop_categories")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Category extends AbstractEntity{

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;



    @ManyToMany(mappedBy = "categories")
    private Collection<Product> products;

}
