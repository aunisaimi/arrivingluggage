package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.repository.ConveyorlaneRepository;
import arriving.luggage.flight.arrivingluggage.model.ConveyorLane;

/**
 * The ConveyorLaneRestController class represents a RESTful API controller 
 * for managing conveyor lanes.
 * 
 * It handles HTTP requests related to conveyor lanes communicates 
 * with the ConveyorlaneRepository to perform 
 * CRUD operations on ConveyorLane entities.
 * The API endpoints defined in this controller 
 * follow the '/api/conveyorlanes' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/conveyorlanes")
public class ConveyorLaneRestController {
    
    @Autowired
    private ConveyorlaneRepository conveyorlaneRepository;
    
    /**
     * Retrieves a list of all conveyor lanes.
     * 
     * @return List of ConveyorLane objects 
     * representing all conveyor lanes in the database.
     */
    @GetMapping
    public List<ConveyorLane> getAllConveyorLanes() {
        return conveyorlaneRepository.findAll();
    }
    
    /**
     * Retrieves a specific conveyor lane by its ID.
     * 
     * @param conveyorLaneID The ID of the conveyor lane to retrieve.
     * @return The ConveyorLane object representing the 
     * conveyor lane with the given ID, or null if not found.
     */
    @GetMapping("{conveyorLaneID}")
    public ConveyorLane getConveyorLaneById(@PathVariable long conveyorLaneID) {
        return conveyorlaneRepository.findById(conveyorLaneID).orElse(null);
        // Alternatively, handle the case when the conveyorlane is not found
        //and return a response accordingly.
        // For example: if (conveyorLane == null) 
        //{ throw new NotFoundException("Conveyor lane not found"); }
    }
    
}
