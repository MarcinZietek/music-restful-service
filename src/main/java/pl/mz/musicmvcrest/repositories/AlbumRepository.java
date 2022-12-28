package pl.mz.musicmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mz.musicmvcrest.domain.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
