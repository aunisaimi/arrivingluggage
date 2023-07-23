package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.ConveyorLane;

/**
 * This interface is the ConveyorlaneRepository 
 * representing a repository for ConveyorLane entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for ConveyorLane entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Syafiqah Nasir
 * 
 */

@Repository
public interface ConveyorlaneRepository extends 
JpaRepository<ConveyorLane, Long> {

}
