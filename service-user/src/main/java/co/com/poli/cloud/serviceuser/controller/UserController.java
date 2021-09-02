package co.com.poli.cloud.serviceuser.controller;

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
        List<Coustomer> coustomer = coustomerService.findAll();
        if (coustomer.isEmpty()) {
            return responseBuilder.failed(coustomer);
        }
        return responseBuilder.success(coustomer);
    }
}
