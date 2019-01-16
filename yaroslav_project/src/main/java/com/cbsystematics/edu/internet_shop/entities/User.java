package com.cbsystematics.edu.internet_shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "eshop_users")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends AbstractEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;



    @OneToOne
    @JoinColumn(name = "user_details_id", unique = true)
    private UserDetails userDetails;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}