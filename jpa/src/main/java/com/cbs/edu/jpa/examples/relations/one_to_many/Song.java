package com.cbs.edu.jpa.examples.relations.one_to_many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}