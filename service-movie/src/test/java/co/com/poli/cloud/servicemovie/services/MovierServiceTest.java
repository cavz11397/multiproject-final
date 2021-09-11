package co.com.poli.cloud.servicemovie.services;

import co.com.poli.cloud.servicemovie.entities.Movie;
import co.com.poli.cloud.servicemovie.repositories.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovierServiceTest {


    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        Movie movie = Movie.builder()
                .title("Inglourious Basterds")
                .director("Quentin tarantino")
                .rating(9)
                .build();
        Mockito.when(movieRepository.findById(11L))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_movie(){
        Movie movie = movieService.findById(11L);
        Assertions.assertThat(movie.getTitle()).isEqualTo("Inglourious Basterds");
    }

}
