package com.cbs.edu.jpa.examples.relationships;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User extends AbstractEntity {

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<HomePet> homePets;

    @ManyToMany
    @JoinTable(name = "users_cities",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private Set<City> cities;
}