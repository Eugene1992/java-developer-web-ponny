package com.cbsystematics.edu.internet_shop.entities;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "p_roles")
public class Role extends AbstractEntity{
    private String name;

    //@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    //private List<User> users;

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
