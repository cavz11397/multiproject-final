package co.com.poli.cloud.servicemovie.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Showtime {

    private Long id;
    private Date date;
    private List<Object> items;

}
