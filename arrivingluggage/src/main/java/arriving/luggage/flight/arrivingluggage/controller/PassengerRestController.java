package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.repository.PassengerRepository;
import arriving.luggage.flight.arrivingluggage.model.Passenger;

/**
 * The PassengerRestController class represents a RESTful API controller 
 * for managing passengers.
 * 
 * It handles HTTP requests related to passengers and communicates 
 * with the PassengerRepository to perform CRUD operations on Passenger entities.
 * The API endpoints defined in this controller 
 * follow the '/api/passengers' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/passengers")
public class PassengerRestController {

    @Autowired
    private PassengerRepository passengerRepository;

    /**
     * Retrieves a list of all passengers.
     * 
     * @return List of Passenger objects representing 
     * all passengers in the database.
     */
    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    /**
     * Retrieves a specific passenger by its ID.
     * 
     * @param passengerId The ID of the passenger to retrieve.
     * @return The Passenger object representing the passenger 
     * with the given ID, or null if not found.
     */
    @GetMapping("{passengerId}")
    public Passenger getPassengerById(@PathVariable long passengerId) {
        return passengerRepository.findById(passengerId).orElse(null);
        // Alternatively, handle the case when the passenger is not found 
        //and return a response accordingly.
        // For example: if (passenger == null) 
        //{ throw new NotFoundException("Passenger not found"); }
    }
}
