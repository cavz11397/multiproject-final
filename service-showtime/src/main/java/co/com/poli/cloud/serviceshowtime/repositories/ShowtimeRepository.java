package co.com.poli.cloud.serviceshowtime.repositories;

import co.com.poli.cloud.serviceshowtime.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

//    Showtime findByMovieId (Long movieId);
}
