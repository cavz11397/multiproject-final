package co.com.poli.cloud.servicebooking.services;

import co.com.poli.cloud.servicebooking.entities.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);

    void delete(Booking booking);

    List<Booking> findAll();

    Booking findById(Long id);

    Booking findByUserId(Long userId);

    Boolean listOfIds(Long movieId);

    Boolean listOfUserIds(Long userId);

}
