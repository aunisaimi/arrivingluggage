package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arriving.luggage.flight.arrivingluggage.model.Staff;

/**
 * This interface is the StaffRepository 
 * representing a repository for Staff entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for Staff entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Anis Sabrina
 * 
 */

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
