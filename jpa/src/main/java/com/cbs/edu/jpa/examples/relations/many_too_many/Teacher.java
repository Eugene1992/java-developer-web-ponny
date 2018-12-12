package com.cbs.edu.jpa.examples.relations.many_too_many;

import com.cbs.edu.jpa.examples.relations.one_to_many.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "album")
public class Teacher {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @ManyToMany(mappedBy = "teachers")
    private Collection<Subject> subjects;
}