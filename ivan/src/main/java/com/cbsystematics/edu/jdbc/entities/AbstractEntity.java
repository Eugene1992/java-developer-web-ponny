package com.cbsystematics.edu.jdbc.entities;

import com.cbsystematics.edu.jdbc.annotations.Column;
import com.cbsystematics.edu.jdbc.annotations.PrimaryKey;

public abstract class AbstractEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
}
