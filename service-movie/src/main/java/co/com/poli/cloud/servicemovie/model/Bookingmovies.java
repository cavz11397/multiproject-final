package co.com.poli.cloud.servicemovie.model;

import lombok.Data;

@Data
public class Bookingmovies {
    private Long id;
    private Long movieId;
    private Movie movie;
}
