package co.com.poli.cloud.serviceshowtime.repositories;

import co.com.poli.cloud.serviceshowtime.entities.ShowtimeItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeItemsRepository extends JpaRepository<ShowtimeItems, Long> {
}
