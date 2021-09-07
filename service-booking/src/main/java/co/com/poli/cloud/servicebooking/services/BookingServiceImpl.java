package co.com.poli.cloud.servicebooking.services;

import co.com.poli.cloud.servicebooking.client.ShowtimeClient;
import co.com.poli.cloud.servicebooking.client.UserClient;
import co.com.poli.cloud.servicebooking.entities.Booking;
import co.com.poli.cloud.servicebooking.model.Showtime;
import co.com.poli.cloud.servicebooking.model.User;
import co.com.poli.cloud.servicebooking.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final ShowtimeClient showtimeClient;

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userClient.findById(booking.getUserId()).getData(),User.class);
        Showtime showtime = modelMapper.map(showtimeClient.findById(booking.getShowtimeId()).getData(),Showtime.class);
        booking.setUser(user);
        booking.setShowtime(showtime);
        return bookingRepository.findById(id).orElse(null);
    }
}
