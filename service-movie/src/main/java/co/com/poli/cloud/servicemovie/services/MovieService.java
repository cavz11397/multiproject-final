package co.com.poli.cloud.servicemovie.services;

import co.com.poli.cloud.servicemovie.entities.Movie;

import java.util.List;

public interface MovieService {
    void save(Movie movie);

    void delete(Movie movie);

    List<Movie> findAll();

    Movie findById(Long id);
}
