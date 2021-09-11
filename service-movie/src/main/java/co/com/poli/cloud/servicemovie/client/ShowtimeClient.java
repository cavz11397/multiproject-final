package co.com.poli.cloud.servicemovie.client;

import co.com.poli.cloud.servicemovie.commons.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-showtime", fallback = ShowtimeClientFallBackHystrix.class)
public interface ShowtimeClient {

    @GetMapping("/showtimes/showtimesId/{movieId}")
    Response findAllIds(@PathVariable("movieId") Long movieId );
}
