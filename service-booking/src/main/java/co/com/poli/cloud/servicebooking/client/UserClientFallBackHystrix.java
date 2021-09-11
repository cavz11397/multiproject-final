package co.com.poli.cloud.servicebooking.client;

import co.com.poli.cloud.servicebooking.commons.Response;
import co.com.poli.cloud.servicebooking.commons.ResponseBuilder;
import co.com.poli.cloud.servicebooking.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientFallBackHystrix implements UserClient {

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        User user = new User();
        user.setName("");
        user.setLastName("");
        return builder.success(user);
    }

}
