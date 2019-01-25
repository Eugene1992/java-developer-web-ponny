package com.cbs.edu.eshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}