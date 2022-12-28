package pl.mz.musicmvcrest.domain;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;

import java.util.Set;

@Data
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    private LocalDate releasedDate;

    private String region;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "albums_tracks", joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id") )
    private Set<Song> albumsTracks;

}
