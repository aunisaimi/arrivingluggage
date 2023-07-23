package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.Airport;

/**
 * This interface is the AirportRepository 
 * representing a repository for Airport entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for Airport entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Syafiqah Nasir
 * 
 */

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}

