package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import arriving.luggage.flight.arrivingluggage.model.Checkpoint;

/**
 * This interface is the CheckpointRepository representing 
 * a repository for Checkpoint entities.
 * 
 * This repository provides CRUD (Create, Read, Update, Delete) 
 * operations for Checkpoint entities.
 * It extends JpaRepository to inherit 
 * basic database operations from Spring Data JPA.
 * 
 * @author Syafiqah Nasir
 * 
 */

@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {

    /**
     * Custom query to find a checkpoint by its ID.
     *
     * @param checkpointID The ID of the checkpoint to find.
     * @return The checkpoint entity with the specified ID.
     */
    @Query(value="SELECT checkpoint from Checkpoint "
    		+ "WHERE checkpointID = :checkpointID", nativeQuery=true)
    public Checkpoint findCheckpointById(@Param("checkpointID") int checkpointID);
    
}
