package co.com.poli.cloud.servicebooking.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Showtime {
    private Long id;
    private Date date;
    private Long movieId;
    private List<Movie> movies;
}
