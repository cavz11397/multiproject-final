package co.com.poli.cloud.servicebooking.repositories;

import co.com.poli.cloud.servicebooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByUserId(Long userId);
}
