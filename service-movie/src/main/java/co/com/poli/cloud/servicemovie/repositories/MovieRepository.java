package co.com.poli.cloud.servicemovie.repositories;

import co.com.poli.cloud.servicemovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
