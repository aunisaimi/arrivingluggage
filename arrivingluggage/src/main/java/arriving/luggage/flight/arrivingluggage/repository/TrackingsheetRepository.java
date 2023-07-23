package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.TrackingSheet;

/**
 * This interface is the TrackingsheetRepository 
 * representing a repository for TrackingSheet entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for TrackingSheet entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Auni Afeeqah
 * 
 */

@Repository
public interface TrackingsheetRepository extends 
JpaRepository<TrackingSheet, Long> {

}
