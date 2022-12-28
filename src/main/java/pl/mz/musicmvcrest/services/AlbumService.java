package pl.mz.musicmvcrest.services;

import pl.mz.musicmvcrest.domain.Album;

import java.util.List;

public interface AlbumService {

    Album findAlbumById(Long id);
    List<Album> findAllAlbums();
}
