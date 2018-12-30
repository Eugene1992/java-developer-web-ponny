package com.cbsystematics.edu.jdbc.entities;

import com.cbsystematics.edu.jdbc.annotations.Column;
import com.cbsystematics.edu.jdbc.annotations.Entity;
import com.cbsystematics.edu.jdbc.annotations.Table;
import lombok.Data;

@Data
@Entity(name = "user")
@Table(name = "users")
public class User extends AbstractEntity{

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;


}
