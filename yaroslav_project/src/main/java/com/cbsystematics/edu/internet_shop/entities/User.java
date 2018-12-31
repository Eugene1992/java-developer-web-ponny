package com.cbsystematics.edu.internet_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "p_users")
public class User extends AbstractEntity {

    private String username;

    private String password;


    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    //@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    //private List<Order> orders;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", userDetails=" + userDetails
                + ", role=" + role
                + ", id=" + id
                + '}';
    }
}