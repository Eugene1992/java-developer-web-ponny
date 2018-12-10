package com.cbs.edu.jdbc.objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

}
