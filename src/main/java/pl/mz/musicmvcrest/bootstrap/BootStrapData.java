package pl.mz.musicmvcrest.bootstrap;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mz.musicmvcrest.domain.Album;
import pl.mz.musicmvcrest.domain.Song;
import pl.mz.musicmvcrest.repositories.AlbumRepository;
import pl.mz.musicmvcrest.repositories.SongRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AlbumRepository albumRepository;

    private final SongRepository songRepository;

    public BootStrapData(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Albums");

        Album a1 = new Album();
        a1.setTitle("Vows");
        a1.setRegion("Australia / New Zealand");
        a1.setReleasedDate(LocalDate.of(2011, 8, 29));
        albumRepository.save(a1);

        Album a2 = new Album();
        a2.setTitle("Astronomia Poety. Baczyński");
        a2.setRegion("Poland");
        a2.setReleasedDate(LocalDate.of(2020, 7, 24));
        albumRepository.save(a2);

        Album a3 = new Album();
        a3.setTitle("A Night At The Opera");
        a3.setRegion("United Kingdom");
        a3.setReleasedDate(LocalDate.of(1975, 11, 21));
        albumRepository.save(a3);

        Album a4 = new Album();
        a4.setTitle("Vows");
        a4.setRegion("North America / Europe");
        a4.setReleasedDate(LocalDate.of(2012, 5, 22));
        albumRepository.save(a4);

        System.out.println("Albums Saved " + albumRepository.count());

        System.out.println("loading Songs ");

//        ToDo

        System.out.println("Songs saved " + songRepository.count());

    }
}
