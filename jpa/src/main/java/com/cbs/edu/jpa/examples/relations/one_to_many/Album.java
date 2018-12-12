package com.cbs.edu.jpa.examples.relations.one_to_many;

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
public class Album {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @OneToMany(mappedBy = "album")
    private Collection<Song> songs;
}