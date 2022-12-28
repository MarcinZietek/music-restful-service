package pl.mz.musicmvcrest.services;

import pl.mz.musicmvcrest.domain.Album;
import pl.mz.musicmvcrest.repositories.AlbumRepository;

import java.util.List;

public class AlbumServiceImpl implements AlbumService{

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album findAlbumById(Long id) {
        return albumRepository.getOne(id);
    }

    @Override
    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }
}
