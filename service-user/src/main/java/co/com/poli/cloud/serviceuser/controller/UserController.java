package co.com.poli.cloud.serviceuser.controller;

import co.com.poli.cloud.serviceuser.commons.Response;
import co.com.poli.cloud.serviceuser.commons.ResponseBuilder;
import co.com.poli.cloud.serviceuser.entities.User;
import co.com.poli.cloud.serviceuser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuilder responseBuilder;

    @GetMapping
    public Response findAll() {
        List<User> user = userService.findAll();
        if (user.isEmpty()) {
            return responseBuilder.failed(user);
        }
        return responseBuilder.success(user);
    }
}
