package com.cbsystematics.edu.eshop.entities;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Version
    protected Integer version;
}
