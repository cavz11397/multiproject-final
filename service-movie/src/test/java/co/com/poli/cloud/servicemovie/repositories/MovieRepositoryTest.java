package co.com.poli.cloud.servicemovie.repositories;

import co.com.poli.cloud.servicemovie.entities.Movie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void FindByRating() {
        Movie movie = Movie.builder()
                .title("Inglourious Basterds")
                .director("Quentin tarantino")
                .rating(9)
                .build();

        movieRepository.save(movie);
        List<Movie> movies = movieRepository.findByDirector(movie.getDirector());

        Assertions.assertThat(movies.size()).isEqualTo(2);
    }

}
