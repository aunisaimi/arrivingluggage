package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.Truck;

/**
 * This interface is the TruckRepository 
 * representing a repository for Truck entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for Truck entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Auni Afeeqah
 * 
 */

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

}

