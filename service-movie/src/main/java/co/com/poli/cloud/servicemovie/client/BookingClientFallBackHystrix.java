package co.com.poli.cloud.servicemovie.client;

import co.com.poli.cloud.servicemovie.commons.Response;
import co.com.poli.cloud.servicemovie.commons.ResponseBuilder;
import co.com.poli.cloud.servicemovie.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingClientFallBackHystrix implements BookingClient {

    private final ResponseBuilder builder;

    @Override
    public Response findAllIds(Long id) {
        Booking booking = new Booking();
        booking.setUserId(0L);
        booking.setUser(null);
        booking.setShowtimeId(0L);
        booking.setShowtime(null);
        booking.setItems(null);
        return builder.success(booking);
    }

}
