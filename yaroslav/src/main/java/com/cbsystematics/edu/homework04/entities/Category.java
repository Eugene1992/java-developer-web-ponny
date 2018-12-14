package com.cbsystematics.edu.homework04.entities;

import com.cbsystematics.edu.homework02.orm.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends AbstractEntity {

    private String name;


    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;


    public Category(String name) {
        this.name = name;
    }
}
