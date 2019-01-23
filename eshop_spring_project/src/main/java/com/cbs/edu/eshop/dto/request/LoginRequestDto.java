package com.cbs.edu.eshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
