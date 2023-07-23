package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arriving.luggage.flight.arrivingluggage.model.Checkpoint;
import arriving.luggage.flight.arrivingluggage.repository.CheckpointRepository;

/**
 * The CheckpointRestController class represents a RESTful API controller 
 * for managing checkpoints.
 * 
 * It handles HTTP requests related to checkpoints communicates 
 * with the CheckpointRepository to perform CRUD operations 
 * on Checkpoint entities.
 * The API endpoints defined in this controller 
 * follow the '/api/checkpoints' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/checkpoints")
public class CheckpointRestController {
    @Autowired
    private CheckpointRepository checkpointRepository;

    /**
     * Retrieves a list of all checkpoints.
     * 
     * @return List of Checkpoint objects 
     * representing all checkpoints in the database.
     */
    @GetMapping
    public List<Checkpoint> getAllCheckpoints() {
        return checkpointRepository.findAll();
    }

    /**
     * Retrieves a specific checkpoint by its ID.
     * 
     * @param checkpointID The ID of the checkpoint to retrieve.
     * @return The Checkpoint object representing 
     * the checkpoint with the given ID, or null if not found.
     */
    @GetMapping("{checkpointID}")
    public Checkpoint getCheckpointById(@PathVariable long checkpointID) {
        return checkpointRepository.findById(checkpointID).orElse(null);
        // Alternatively, handle the case when the checkpoint is not found
        //and return a response accordingly.
        // For example: if (checkpoint == null) 
        //{ throw new NotFoundException("Checkpoint not found"); }
    }
    
}
