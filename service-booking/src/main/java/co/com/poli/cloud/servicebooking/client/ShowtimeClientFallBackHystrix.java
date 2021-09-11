package co.com.poli.cloud.servicebooking.client;

import co.com.poli.cloud.servicebooking.commons.Response;
import co.com.poli.cloud.servicebooking.commons.ResponseBuilder;
import co.com.poli.cloud.servicebooking.model.Showtime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class ShowtimeClientFallBackHystrix implements ShowtimeClient {

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        Showtime showtime = new Showtime();
        showtime.setDate(new Date());
        showtime.setItems(null);
        return builder.success(showtime);
    }

}
