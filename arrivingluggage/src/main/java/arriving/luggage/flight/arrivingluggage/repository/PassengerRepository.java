package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import arriving.luggage.flight.arrivingluggage.model.Passenger;
import org.springframework.stereotype.Repository;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
