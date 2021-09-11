package co.com.poli.cloud.servicebooking.model;

import lombok.Data;

@Data
public class ShowtimeItems {

    private Long id;
    private Long movieId;
    private Movie movie;

}
