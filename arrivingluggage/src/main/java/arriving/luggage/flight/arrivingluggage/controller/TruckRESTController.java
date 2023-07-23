package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.repository.TruckRepository;
import arriving.luggage.flight.arrivingluggage.model.Truck;

/**
 * The TruckRestController class represents a RESTful API controller 
 * for managing trucks.
 * 
 * It handles HTTP requests related to trucks and communicates 
 * with the TruckRepository to perform CRUD operations on Truck entities.
 * The API endpoints defined in this controller 
 * follow the '/api/trucks' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/trucks")
public class TruckRestController {

    @Autowired
    private TruckRepository truckRepository;

    /**
     * Retrieves a list of all trucks.
     * 
     * @return List of Truck objects representing all trucks in the database.
     */
    @GetMapping
    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    /**
     * Retrieves a specific truck by its ID.
     * 
     * @param truckId The ID of the truck to retrieve.
     * @return The Truck object representing the truck with the given ID, 
     * or null if not found.
     */
    @GetMapping("{truckId}")
    public Truck getTruckById(@PathVariable long truckId) {
        return truckRepository.findById(truckId).orElse(null);
        // Alternatively, handle the case when the truck is 
        //not found and return a response accordingly.
        // For example: if (truck == null) 
        //{ throw new NotFoundException("Truck not found"); }
    }
}
