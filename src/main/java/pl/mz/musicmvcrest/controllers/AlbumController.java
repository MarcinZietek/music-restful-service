package pl.mz.musicmvcrest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.mz.musicmvcrest.domain.Album;
import pl.mz.musicmvcrest.repositories.AlbumRepository;
import pl.mz.musicmvcrest.services.AlbumServiceImpl;

import java.util.List;

@RestController
@RequestMapping(AlbumController.BASE_URL)
public class AlbumController {

    public static final String BASE_URL = "/api/v1/albums";
    private final AlbumServiceImpl albumService;

    public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @GetMapping()
    List<Album> getAllAlbums(){
        return albumService.findAllAlbums();
    }

    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable Long id){
        return albumService.findAlbumById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        albumService.updateAlbum(album);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable Long id){
        albumService.deleteAlbumById(id);
    }
}
