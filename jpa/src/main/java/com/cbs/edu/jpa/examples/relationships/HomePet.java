package com.cbs.edu.jpa.examples.relationships;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "home_pets")
@ToString(exclude = "user")
public class HomePet extends AbstractEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
