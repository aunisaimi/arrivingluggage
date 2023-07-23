package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.model.Luggage;

/**
 * The LuggageMenuController class handles the web application's views 
 * and requests related to luggage management.
 * It communicates with the Luggage RESTful API 
 * to retrieve and display luggage information.
 * 
 * @author Auni Afeeqah
 *
 */
@Controller
public class LuggageMenuController {
	
	private String defaultURI = "http://localhost:8080/arriving/api/luggages";
	
	/**
	 * Retrieves a list of all luggages and displays them on the "luggage" page.
	 * 
	 * @param model The model to attach the list of luggages.
	 * @return The view name for the "luggage" page.
	 */
	@GetMapping("/luggage/list")
	public String getLuggage(Model model) {
		// The URI to GET luggage
		String uri = "http://localhost:8080/arriving/api/luggages";
		
		// Get a list of luggages from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = 
				restTemplate.getForEntity(uri, Luggage[].class);
		
		// Parse JSON data to an array of objects
		Luggage[] luggages = response.getBody();
		
		// Convert the array to a list
		List<Luggage> luggageList = Arrays.asList(luggages);
		
		// Attach the list to the model as an attribute
		model.addAttribute("luggages", luggageList);
		
		// Return the view name for the "luggage" page
		return "luggage";
	}
	
	/**
	 * Retrieves a specific luggage by its ID 
	 * and displays it on the "luggageinfo" page.
	 * 
	 * @param LuggagE The ID of the luggage to retrieve.
	 * @param model The model to attach the luggage data.
	 * @return The view name for the "luggageinfo" page.
	 */
	@GetMapping("/luggage/{LuggagE}")
	public String getLuggage(@PathVariable Integer LuggagE, Model model) {
		String pageTitle = "New Luggage";
		Luggage luggage = new Luggage();
		
		// This block gets luggage to be updated
		if (LuggagE > 0) {
			// Generate a new URI and append LuggageId to it
			String uri = defaultURI + "/" + LuggagE;
			
			// Get a luggage from the web service
			RestTemplate restTemplate = new RestTemplate();
			luggage = restTemplate.getForObject(uri, Luggage.class);
			
			// Give a new title to the page
			pageTitle = "Edit Luggage";
		}
		
		// Attach values to pass to the front end
		model.addAttribute("luggages", luggage);
		model.addAttribute("pageTitle", pageTitle);
		
		return "luggageinfo";		
	}
}
