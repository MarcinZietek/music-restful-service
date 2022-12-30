package pl.mz.musicmvcrest.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mz.musicmvcrest.domain.Album;
import pl.mz.musicmvcrest.repositories.AlbumRepository;

import java.util.List;
import java.util.NoSuchElementException;

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

    @Transactional
    @Override
    public void updateAlbum(Album album) {
        Album foundAlbum = albumRepository.findById(album.getId()).get();
        if (!foundAlbum.getId().equals(album.getId())){
            throw new NoSuchElementException();
        } else {
            foundAlbum.setTitle(album.getTitle());
            foundAlbum.setRegion(album.getRegion());
            foundAlbum.setReleasedDate(album.getReleasedDate());
            albumRepository.save(album);
        }
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
    }
}
