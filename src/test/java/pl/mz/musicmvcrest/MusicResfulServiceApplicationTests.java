package pl.mz.musicmvcrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mz.musicmvcrest.domain.Album;
import pl.mz.musicmvcrest.repositories.AlbumRepository;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class MusicRestfulServiceApplicationTests {

	@Autowired
	AlbumRepository albumRepository;

	@Test
	void testAlbumService(){
		long count = albumRepository.count();

		assertThat(count).isGreaterThan(0);
	}

	@Test
	void testSavedAlbum(){
		long countBefore = albumRepository.count();

		Album newAlbum = new Album();
		newAlbum.setTitle("Astronomia Poety. Baczyński");
		newAlbum.setRegion("Poland");
		newAlbum.setReleasedDate(LocalDate.of(2020, 7, 24));
		albumRepository.save(newAlbum);

		long countAfter = albumRepository.count();
		System.out.println("Albums Saved " + albumRepository.count());

		assertThat(countBefore).isLessThan(countAfter);
	}

	@Test
	void testAlbumDeleted(){
		long countBefore = albumRepository.count();

		Album newAlbum = new Album();
		newAlbum.setTitle("Astronomia Poety. Baczyński");
		newAlbum.setRegion("Poland");
		newAlbum.setReleasedDate(LocalDate.of(2020, 7, 24));
		albumRepository.save(newAlbum);

		albumRepository.deleteById(newAlbum.getId());
		long countAfter = albumRepository.count();

		assertThat(countAfter).isEqualTo(countBefore);
	}

	void testFindAlbumById(){

	}

}
