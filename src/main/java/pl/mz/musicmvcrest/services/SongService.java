package pl.mz.musicmvcrest.services;

import pl.mz.musicmvcrest.domain.Song;

import java.util.List;

public interface SongService {

    Song findSongById(Long id);
    List<Song> findAllSongs();
    Song saveSong(Song song);
    void updateSong(Song song);
    void deleteSongById(Long id);
}
