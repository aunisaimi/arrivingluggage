package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arriving.luggage.flight.arrivingluggage.model.Flight;
import arriving.luggage.flight.arrivingluggage.repository.FlightRepository;

/**
 * The FlightRestController class 
 * represents a RESTful API controller for managing flights.
 * 
 * It handles HTTP requests related to flights and communicates 
 * with the FlightRepository to perform CRUD operations on Flight entities.
 * The API endpoints defined in this controller 
 * follow the '/api/flights' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/flights")
public class FlightRestController {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * Retrieves a list of all flights.
     * 
     * @return List of Flight objects representing all flights in the database.
     */
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    /**
     * Retrieves a specific flight by its ID.
     * 
     * @param FlightId The ID of the flight to retrieve.
     * @return The Flight object representing the flight 
     * with the given ID, or null if not found.
     */
    @GetMapping("{FlightId}")
    public Flight getFlightById(@PathVariable long FlightId) {
        return flightRepository.findById(FlightId).orElse(null);
        // Alternatively, handle the case when the flight is not found 
        //and return a response accordingly.
        // For example: if (flight == null) 
        //{ throw new NotFoundException("Flight not found"); }
    }
    
}
