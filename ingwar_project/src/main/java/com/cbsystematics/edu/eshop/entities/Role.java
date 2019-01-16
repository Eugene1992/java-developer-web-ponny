package com.cbsystematics.edu.eshop.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {
    @Column(unique = true, nullable = false)
    private String name;
}
