package com.cbsystematics.edu.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shop_users")
public class User extends AbstractEntity {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orders;
}
