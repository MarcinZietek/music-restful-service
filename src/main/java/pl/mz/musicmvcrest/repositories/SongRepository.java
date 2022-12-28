package pl.mz.musicmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mz.musicmvcrest.domain.Song;

@Repository
public interface SongRepository extends JpaRepository <Song, Long> {
}
