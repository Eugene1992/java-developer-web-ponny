package com.cbs.edu.jpa.examples.relationships.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true, exclude = "users")
@Entity
@Table(name = "cities")
@Data
public class City extends AbstractEntity {
    private String name;

    @ManyToMany(mappedBy = "cities")
    private Collection<User> users;
}
