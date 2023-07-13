package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.ConveyorLane;

@Repository
public interface ConveyerlaneRepository extends JpaRepository<ConveyorLane, Long> 
{

}
