package com.cbs.edu.structure.entities;

import com.cbs.edu.structure.orm.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {
    @Id
    protected Integer id;
}
