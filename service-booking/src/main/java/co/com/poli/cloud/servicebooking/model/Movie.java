package co.com.poli.cloud.servicebooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {

    private Long id;
    private String title;
    private String director;
    private int rating;

}
