package co.com.poli.cloud.serviceshowtime.services;

import co.com.poli.cloud.serviceshowtime.entities.Showtime;

import java.util.List;

public interface ShowtimeService {
    void save(Showtime showtime);

    void delete(Showtime showtime);

    List<Showtime> findAll();

    Showtime findById(Long id);

    Showtime update(Showtime showtime);

    Boolean listOfIds(Long movieId);

//    Showtime findByMovieId(Long movieId);

}
