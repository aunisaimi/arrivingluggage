package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.Passenger;

/**
 * This interface is the PassengerRepository 
 * representing a repository for Passenger entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for Passenger entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Anis Sabrina
 * 
 */

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
