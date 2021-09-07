package co.com.poli.cloud.serviceshowtime.services;

import co.com.poli.cloud.serviceshowtime.client.MovieClient;
import co.com.poli.cloud.serviceshowtime.entities.Showtime;
import co.com.poli.cloud.serviceshowtime.entities.ShowtimeItems;
import co.com.poli.cloud.serviceshowtime.model.Movie;
import co.com.poli.cloud.serviceshowtime.repositories.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MovieClient movieClient;

    @Override
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    public void delete(Showtime showtime) {
        showtimeRepository.delete(showtime);
    }

    @Override
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime findById(Long id) {
        Showtime showtime = showtimeRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        List<ShowtimeItems> itemList = showtime.getItems()
                .stream()
                .map(showtimeItem -> {
                    System.out.println("movieid");
                    System.out.println(showtimeItem.getMovieId());
                    System.out.println("respuesta");
                    System.out.println(movieClient.findById(showtimeItem.getMovieId()).getData());
                    Movie movie = modelMapper.map(movieClient.findById(showtimeItem.getMovieId()).getData(), Movie.class);
                    System.out.println("movie");
                    System.out.println(movie);
                    showtimeItem.setMovie(movie);
                    return showtimeItem;
                })
                .collect(Collectors.toList());
        return showtimeRepository.findById(id).orElse(null);
    }

    /*@Override
    public Showtime findByMovieId(Long movieId) {
        Showtime showtime = showtimeRepository.findByMovieId(movieId);
        ModelMapper modelMapper = new ModelMapper();
        Movie movie  = modelMapper.map(movieClient.findById(showtime.getMovieId()).getData(),Movie.class);
        List<Movie> lista = null;
        lista.add(movie);
        showtime.setMovies(lista);
        return showtimeRepository.findByMovieId(movieId);
    }*/
}