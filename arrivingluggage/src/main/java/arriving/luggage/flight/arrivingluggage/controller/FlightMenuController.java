package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.model.Flight;

/**
 * The FlightMenuController class represents 
 * a controller that interacts with a RESTful web service 
 * to manage flight details.
 * It handles HTTP requests related to flights 
 * and communicates with the flight API.
 * This controller provides methods 
 * to retrieve, update, and add flight information.
 * 
 * @author Anis Sabrina
 * 
 */
@Controller
public class FlightMenuController {

	private String defaultURI = "http://localhost:8080/arriving/api/flights";

	/**
	 * Retrieves and displays flight details.
	 * 
	 * @param model The model to be used for the view.
	 * @return The view name for flight details.
	 */
	@GetMapping("/flight/list")
	public String getFlight(Model model) {
		// The URI to GET the flight
		String uri = "http://localhost:8080/arriving/api/flights";

		// Get a list of flights from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Flight[]> response = 
				restTemplate.getForEntity(uri, Flight[].class);

		// Parse JSON data to an array of objects
		Flight[] flights = response.getBody();

		// Convert the array to a list of objects
		List<Flight> flightList = Arrays.asList(flights);

		// Attach the list to the model as an attribute for the front end
		model.addAttribute("flights", flightList);

		return "flight";
	}

	/**
	 * Updates or adds a flight.
	 * 
	 * @param flight The flight object to be updated or added.
	 * @return The redirect URL to display a list of flights.
	 */
	@RequestMapping("/flight/save")
	public String updateFlight(@ModelAttribute Flight flight) {
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Create a request Body
		HttpEntity<Flight> request = new HttpEntity<Flight>(flight);

		String flightResponse = " ";

		if (flight.getFlightID() > 0) {
			// This block updates an existing flight

			// Send request as PUT
			restTemplate.put(defaultURI, request, Flight.class);
		} else {
			// This block adds a new flight

			// Send request as POST
			flightResponse = restTemplate.postForObject
					(defaultURI, request, String.class);
		}

		System.out.println(flightResponse);

		// Redirect the request to display a list of flights
		return "redirect:/flight/list";
	}

	/**
	 * Retrieves a flight by its ID.
	 * 
	 * @param FlighT The ID of the flight to retrieve.
	 * @param model  The model to be used for the view.
	 * @return The view name for flight information.
	 */
	@GetMapping("/flight/{FlighT}")
	public String getFlight(@PathVariable Integer FlighT, Model model) {
		String pageTitle = "New Flight";
		Flight flight = new Flight();

		// This block gets the flight to be updated
		if (FlighT > 0) {

			// Generate a new URI and append Flight to it
			String uri = defaultURI + "/" + FlighT;

			// Get a flight from the web service
			RestTemplate restTemplate = new RestTemplate();
			flight = restTemplate.getForObject(uri, Flight.class);

			// Change the title of the page
			pageTitle = "Edit Flight";
		}

		// Attach the flight value from the database 
		//to be passed to the front end
		model.addAttribute("flight", flight);
		model.addAttribute("pageTitle", pageTitle);

		return "flightinfo";
	}
	
}