package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.Luggage;

/**
 * This interface is the LuggageRepository 
 * representing a repository for Luggage entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for Luggage entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Auni Afeeqah
 * 
 */

@Repository
public interface LuggageRepository extends JpaRepository<Luggage, Long> {

}
