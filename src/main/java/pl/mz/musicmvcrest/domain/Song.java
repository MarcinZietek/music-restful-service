package pl.mz.musicmvcrest.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Float duration;

    @ManyToMany
    @JoinTable(name = "albums_tracks",
            joinColumns = @JoinColumn(name= "song_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"))
    private Set<Album> albums;

}
