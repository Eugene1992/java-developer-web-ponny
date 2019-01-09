package com.cbsystematics.edu.internet_shop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
@Data
@NoArgsConstructor

//@Entity
//@Table(name = "p_user_details")
public class UserDetails extends AbstractEntity {

    //@Column(name = "first_name")
    private String firstName;

    //@Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;

    //@OneToOne(mappedBy = "userDetails")
    //private User user;

    public UserDetails(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }


    public UserDetails(Integer id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.version = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

}
