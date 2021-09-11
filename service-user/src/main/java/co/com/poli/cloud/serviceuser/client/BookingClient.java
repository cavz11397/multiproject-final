package co.com.poli.cloud.serviceuser.client;

import co.com.poli.cloud.serviceuser.commons.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-booking", fallback = BookingClientFallBackHystrix.class)
public interface BookingClient {
    @GetMapping("/bookings/bookingsUserId/{userId}")
    Response findAllUserIds(@PathVariable("userId") Long userId );
}
