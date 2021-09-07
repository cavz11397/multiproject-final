package co.com.poli.cloud.servicebooking.entities;

import co.com.poli.cloud.servicebooking.model.Movie;
import co.com.poli.cloud.servicebooking.model.Showtime;
import co.com.poli.cloud.servicebooking.model.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "showtimeId", nullable = false)
    private Long showtimeId;

    @Transient
    private User user;

    @Transient
    private Showtime showtime;

    private Movie[] movies;

}
