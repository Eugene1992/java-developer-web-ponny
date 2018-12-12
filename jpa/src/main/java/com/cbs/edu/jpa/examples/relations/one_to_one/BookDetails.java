package com.cbs.edu.jpa.examples.relations.one_to_one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_details")
public class BookDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String genre;

    private Integer numOfPages;
}