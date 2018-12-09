package com.cbsystematics.edu.homework02.entities;


import com.cbsystematics.edu.homework02.orm.PrimaryId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity {

    @PrimaryId(name = "id")
    protected Integer id;
}
