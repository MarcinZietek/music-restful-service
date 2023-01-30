package pl.mz.musicmvcrest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.mz.musicmvcrest.domain.Song;
import pl.mz.musicmvcrest.services.SongServiceImpl;

import java.util.List;

@RestController
@RequestMapping(SongController.BASE_URL)
public class SongController {

    public static final String BASE_URL = "/api/v1/songs";
    private final SongServiceImpl songService;

    public SongController(SongServiceImpl songService) {
        this.songService = songService;
    }

    @GetMapping()
    List<Song> getAllSongs() { return songService.findAllSongs(); }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Song getSongById(@PathVariable Long id) { return songService.findSongById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song saveSong(@RequestBody Song song) { return songService.saveSong(song); }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSong(@PathVariable Long id, @RequestBody Song song){ songService.updateSong(song);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSong(@PathVariable Long id) { songService.deleteSongById(id);}

}
