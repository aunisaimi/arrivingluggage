package arriving.luggage.flight.arrivingluggage.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import arriving.luggage.flight.arrivingluggage.model.Airport;

/**
 * This class is the AirportMenuController 
 * representing the controller for airport menu operations.
 * 
 * It is responsible for handling 
 * HTTP requests related to the airport menu page.
 * It communicates with a RESTful API 
 * to retrieve a list of airports and provides it to the frontend.
 * 
 * @author Auni Afeeqah
 *
 */

@Controller
public class AirportMenuController {

    /**
     * GET endpoint for the airport list page.
     * Retrieves a list of airports from a RESTful API 
     * and adds it to the model for frontend rendering.
     *
     * @param model The model used to pass data to the frontend.
     * @return The name of the view (HTML page) 
     * to be rendered for the airport list page.
     */
    @GetMapping("/airport/list")
    public String getAirportList(Model model) {
        // The URI to GET the airport list from the API
        String uri = "http://localhost:8080/arriving/api/airports";

        // Create a RestTemplate to perform HTTP requests
        RestTemplate restTemplate = new RestTemplate();

        // Send a GET request to the API and 
        //retrieve the response as an array of Airport objects
        ResponseEntity<Airport[]> response =
                restTemplate.getForEntity(uri, Airport[].class);

        // Extract the Airport array from the response
        Airport[] airports = response.getBody();

        // Convert the array to a list of Airport objects
        List<Airport> airportList = Arrays.asList(airports);

        // Add the list of airports to the model 
        //as an attribute for frontend rendering
        model.addAttribute("airports", airportList);

        // Return the name of the view (HTML page) 
        //to be rendered for the airport list page
        return "airport";
    }
    
}
