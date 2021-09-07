package co.com.poli.cloud.servicebooking.controller;

import co.com.poli.cloud.servicebooking.commons.ErrorMessage;
import co.com.poli.cloud.servicebooking.commons.Response;
import co.com.poli.cloud.servicebooking.commons.ResponseBuilder;
import co.com.poli.cloud.servicebooking.entities.Booking;
import co.com.poli.cloud.servicebooking.services.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuilder responseBuilder;

    @GetMapping
    public Response findAll() {
        List<Booking> booking = bookingService.findAll();
        if (booking.isEmpty()) {
            return responseBuilder.failed(booking);
        }
        return responseBuilder.success(booking);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id ){
        Booking booking = bookingService.findById(id);
        if(booking == null){
            return responseBuilder.failed(null);
        }
        return responseBuilder.success(booking);
    }
//
//    @PostMapping
//    public Response save(@Valid @RequestBody Showtime showtime, BindingResult result) {
//        if (result.hasErrors()) {
//            return responseBuilder.failed(this.formatMessage((result)));
//        }
//        showtimeService.save(showtime);
//        return responseBuilder.success(showtime);
//    }
//
//    @DeleteMapping("/{id}")
//    public Response delete(@PathVariable("id") Long id) {
//        Showtime showtime = showtimeService.findById(id);
//        if (showtime == null) {
//            return responseBuilder.failed(null);
//        }
//        showtimeService.delete(showtime);
//        return responseBuilder.success(showtime);
//    }

    public String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
