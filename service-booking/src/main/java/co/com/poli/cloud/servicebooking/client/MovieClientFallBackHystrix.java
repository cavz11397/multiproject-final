package co.com.poli.cloud.servicebooking.client;

import co.com.poli.cloud.servicebooking.commons.Response;
import co.com.poli.cloud.servicebooking.commons.ResponseBuilder;
import co.com.poli.cloud.servicebooking.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientFallBackHystrix implements MovieClient{

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        Movie movie = new Movie();
                movie.setTitle("");
                movie.setDirector("");
                movie.setRating(0);
        return  builder.success(movie);
    }

}
