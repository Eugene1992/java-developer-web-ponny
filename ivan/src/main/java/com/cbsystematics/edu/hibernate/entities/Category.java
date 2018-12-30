package com.cbsystematics.edu.hibernate.entities;

import com.cbsystematics.edu.jdbc.annotations.Entity;
import com.cbsystematics.edu.jdbc.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category")
@Table(name = "categories")
public class Category {

    private String name;
}
