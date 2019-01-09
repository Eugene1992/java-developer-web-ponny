package com.cbsystematics.edu.internet_shop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
@Data
@NoArgsConstructor

//@Entity
//@Table(name = "p_users")
public class User extends AbstractEntity {

    private String username;

    private String password;

    private Integer roleId;

    private Integer userDetailsId;


    //@OneToOne
    //@JoinColumn(name = "user_details_id")
    private UserDetails userDetails = new UserDetails();


    //@ManyToOne
    //@JoinColumn(name = "role_id")
    private Role role = new Role();


    //@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    //private List<Order> orders;


    public User(Integer id, String username, String password, Integer roleId, Integer userDetailsId) {
        this.id = id;
        this.version = 0;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.userDetailsId = userDetailsId;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.version = 0;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getFirstName() {
        return userDetails.getFirstName();
    }

    public String getLastName() {
        return userDetails.getLastName();
    }

    public String getEmail() {
        return userDetails.getEmail();
    }

    public String getPhone() {
        return userDetails.getPhone();
    }

    public String getRoleName() {
        return role.getName();
    }
}