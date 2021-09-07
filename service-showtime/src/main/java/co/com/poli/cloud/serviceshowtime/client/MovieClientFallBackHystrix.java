package co.com.poli.cloud.serviceshowtime.client;

import co.com.poli.cloud.serviceshowtime.commons.Response;
import co.com.poli.cloud.serviceshowtime.commons.ResponseBuilder;
import co.com.poli.cloud.serviceshowtime.model.Movie;
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
