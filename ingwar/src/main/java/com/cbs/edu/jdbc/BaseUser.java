package com.cbs.edu.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseUser {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
}
