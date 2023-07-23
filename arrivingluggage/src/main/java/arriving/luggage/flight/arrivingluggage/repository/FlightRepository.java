package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.Flight;

/**
 * This interface is the FlightRepository 
 * representing a repository for Flight entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for Flight entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Syafiqah Nasir
 * 
 */

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
