package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.TrackingSheet;


@Repository
public interface TrackingsheetRepository extends JpaRepository<TrackingSheet, Long> {

}
