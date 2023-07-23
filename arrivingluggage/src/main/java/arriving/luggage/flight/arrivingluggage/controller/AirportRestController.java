package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arriving.luggage.flight.arrivingluggage.model.Airport;
import arriving.luggage.flight.arrivingluggage.repository.AirportRepository;

/**
 * The AirportRestController class 
 * represents a RESTful API controller for managing airports.
 * 
 * It handles HTTP requests related to airports
 * communicates with the AirportRepository to perform 
 * CRUD operations on the Airport entities.
 * The API endpoints defined in this controller 
 * follow the '/api/airports' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/airports")
public class AirportRestController {

    @Autowired
    private AirportRepository airportRepository;

    /**
     * Retrieves a list of all airports.
     * 
     * @return List of Airport objects representing all airports in the database.
     */
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    /**
     * Retrieves a specific airport by its ID.
     * 
     * @param airportID The ID of the airport to retrieve.
     * @return The Airport object 
     * representing the airport with the given ID, or null if not found.
     */
    @GetMapping("{airportID}")
    public Airport getAirportById(@PathVariable long airportID) {
        return airportRepository.findById(airportID).orElse(null);
        // Alternatively, handle the case when the airport is not found
        //return a response accordingly.
        // For example: if (airport == null) 
        //{ throw new NotFoundException("Airport not found"); }
    }
}
