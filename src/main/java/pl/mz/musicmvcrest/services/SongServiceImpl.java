package pl.mz.musicmvcrest.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mz.musicmvcrest.domain.Song;
import pl.mz.musicmvcrest.repositories.SongRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song findSongById(Long id) {
        return songRepository.findById(id).get();
    }

    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Transactional
    @Override
    public void updateSong(Song song) {
        Song foundSong = songRepository.findById(song.getId()).get();
        if (!foundSong.getId().equals(song.getId())){
            throw new NoSuchElementException();
        } else {
            foundSong.setTitle(song.getTitle());
            foundSong.setDuration(song.getDuration());
            foundSong.setAlbums(song.getAlbums());
            songRepository.save(song);
        }
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }
}
