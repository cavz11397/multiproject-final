package co.com.poli.cloud.servicebooking.services;

import co.com.poli.cloud.servicebooking.client.MovieClient;
import co.com.poli.cloud.servicebooking.client.ShowtimeClient;
import co.com.poli.cloud.servicebooking.client.UserClient;
import co.com.poli.cloud.servicebooking.entities.Booking;
import co.com.poli.cloud.servicebooking.entities.Bookingmovies;
import co.com.poli.cloud.servicebooking.model.Movie;
import co.com.poli.cloud.servicebooking.model.Showtime;
import co.com.poli.cloud.servicebooking.model.User;
import co.com.poli.cloud.servicebooking.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final ShowtimeClient showtimeClient;
    private final MovieClient movieClient;

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
        List<Booking> items = bookingRepository.findAll();
        items.stream()
                .map(booking -> {
                    return booking = findById(booking.getId());
                })
                .collect(Collectors.toList());
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userClient.findById(booking.getUserId()).getData(), User.class);
        booking.setUser(user);

        Showtime showtime = modelMapper.map(showtimeClient.findById(booking.getShowtimeId()).getData(), Showtime.class);
        booking.setShowtime(showtime);

        List<Bookingmovies> itemList = booking.getItems()
                .stream()
                .map(bookingmovies -> {
                    Movie movie = modelMapper.map(movieClient.findById(bookingmovies.getMovieId()).getData(), Movie.class);
                    bookingmovies.setMovie(movie);
                    return bookingmovies;
                })
                .collect(Collectors.toList());

        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByUserId(Long userId) {
        Booking booking = bookingRepository.findByUserId(userId);
        if(booking != null){
            return  findById(booking.getId());
        }
        return null;
    }
}
