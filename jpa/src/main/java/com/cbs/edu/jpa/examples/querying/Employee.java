package com.cbs.edu.jpa.examples.querying;

import com.cbs.edu.jpa.examples.relationships.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Integer age;

    private Integer salary;

    private String gender;

    private String email;
}
