package com.cbs.edu.jpa.examples.relations.one_to_one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @OneToOne
    @JoinColumn(name="book_details_id")
    private BookDetails bookDetails;

    @OneToOne
    @JoinColumn(name="book_publisher_id")
    private BookPublisher bookPublisher;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bookDetails=" + bookDetails +
                ", bookPublisher=" + bookPublisher.getName() +
                '}';
    }
}