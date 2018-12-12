package com.cbs.edu.jpa.examples.relations.one_to_one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_publisher")
public class BookPublisher {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToOne(mappedBy = "bookPublisher")
    private Book book;

    @Override
    public String toString() {
        return "BookPublisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book.getTitle() +
                '}';
    }
}