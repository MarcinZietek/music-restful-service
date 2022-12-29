package pl.mz.musicmvcrest.services;

import org.springframework.stereotype.Service;
import pl.mz.musicmvcrest.domain.Album;
import pl.mz.musicmvcrest.repositories.AlbumRepository;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album findAlbumById(Long id) {
        return albumRepository.findById(id).get();
    }

    @Override
    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void updateAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
    }
}
