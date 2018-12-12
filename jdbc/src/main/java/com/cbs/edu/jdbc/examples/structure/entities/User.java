package com.cbs.edu.jdbc.examples.structure.entities;

import com.cbs.edu.jdbc.examples.structure.orm.Column;
import com.cbs.edu.jdbc.examples.structure.orm.Entity;
import com.cbs.edu.jdbc.examples.structure.orm.Table;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String username;

    private String password;

    private String email;

    public User(Integer id, String firstName, String lastName, String username, String password, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
