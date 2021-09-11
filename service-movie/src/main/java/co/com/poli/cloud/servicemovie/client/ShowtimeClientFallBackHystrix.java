package co.com.poli.cloud.servicemovie.client;

import co.com.poli.cloud.servicemovie.commons.Response;
import co.com.poli.cloud.servicemovie.commons.ResponseBuilder;
import co.com.poli.cloud.servicemovie.model.Showtime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class ShowtimeClientFallBackHystrix implements ShowtimeClient {

    private final ResponseBuilder builder;

    @Override
    public Response findAllIds(Long id) {
        Showtime showtime = new Showtime();
        showtime.setDate(new Date());
        showtime.setItems(null);
        return builder.success(showtime);
    }

}
