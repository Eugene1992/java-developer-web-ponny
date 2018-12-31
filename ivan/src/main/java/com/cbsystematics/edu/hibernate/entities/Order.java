package com.cbsystematics.edu.hibernate.entities;

import com.cbsystematics.edu.jdbc.annotations.Entity;
import com.cbsystematics.edu.jdbc.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order")
@Table(name = "orders")
public class Order extends AbstractEntity{

    @ManyToOne
    private Integer userId;

}
