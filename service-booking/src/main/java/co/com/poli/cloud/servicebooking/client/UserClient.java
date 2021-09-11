package co.com.poli.cloud.servicebooking.client;

import co.com.poli.cloud.servicebooking.commons.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user", fallback = UserClientFallBackHystrix.class)
public interface UserClient {

    @GetMapping("/users/{id}")
    Response findById(@PathVariable("id") Long id );
}
