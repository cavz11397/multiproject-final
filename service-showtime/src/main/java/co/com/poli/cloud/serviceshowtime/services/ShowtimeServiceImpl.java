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
        List<Showtime> items =showtimeRepository.findAll();
        items.stream()
                .map(showtime -> {
                    return showtime = findById(showtime.getId());
                })
                .collect(Collectors.toList());
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime findById(Long id) {
        Showtime showtime = showtimeRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        List<ShowtimeItems> itemList = showtime.getItems()
                .stream()
                .map(showtimeItem -> {
                    Movie movie = modelMapper.map(movieClient.findById(showtimeItem.getMovieId()).getData(), Movie.class);
                    showtimeItem.setMovie(movie);
                    return showtimeItem;
                })
                .collect(Collectors.toList());
        return showtimeRepository.findById(id).orElse(null);
    }

}
