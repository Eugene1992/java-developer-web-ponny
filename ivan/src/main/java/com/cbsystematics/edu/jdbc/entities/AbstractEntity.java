package com.cbsystematics.edu.jdbc.entities;

import com.cbsystematics.edu.jdbc.annotations.Column;
import com.cbsystematics.edu.jdbc.annotations.PrimaryKey;
import com.cbsystematics.edu.jdbc.dao.DAO;

public abstract class AbstractEntity {
    @PrimaryKey
    @Column(name = "id")
    Integer id;
}
