package com.cbsystematics.edu.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetails extends AbstractEntity{
    private String city;
    private String phone;
    private int age;
}
