package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.repository.LuggageRepository;
import arriving.luggage.flight.arrivingluggage.model.Luggage;

/**
 * The LuggageRestController class represents a RESTful API controller 
 * for managing luggages.
 * 
 * It handles HTTP requests related to luggages and communicates 
 * with the LuggageRepository to perform CRUD operations on Luggage entities.
 * The API endpoints defined in this controller 
 * follow the '/api/luggages' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/luggages")
public class LuggageRestController {

    @Autowired
    private LuggageRepository luggageRepository;

    /**
     * Retrieves a list of all luggages.
     * 
     * @return List of Luggage objects 
     * representing all luggages in the database.
     */
    @GetMapping
    public List<Luggage> getAllLuggages() {
        return luggageRepository.findAll();
    }

    /**
     * Retrieves a specific luggage by its ID.
     * 
     * @param luggageID The ID of the luggage to retrieve.
     * @return The Luggage object 
     * representing the luggage with the given ID, or null if not found.
     */
    @GetMapping("{luggageID}")
    public Luggage getLuggageById(@PathVariable long luggageID) {
        return luggageRepository.findById(luggageID).orElse(null);
        // Alternatively, handle the case when the luggage is not found 
        //and return a response accordingly.
        // For example: if (luggage == null) 
        //{ throw new NotFoundException("Luggage not found"); }
    }
    
}
