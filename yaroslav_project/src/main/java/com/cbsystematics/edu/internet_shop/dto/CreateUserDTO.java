package com.cbsystematics.edu.internet_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phone;

    private String password;

    private String confirmPassword;
}
