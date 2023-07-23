package arriving.luggage.flight.arrivingluggage.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.model.Flight;
import arriving.luggage.flight.arrivingluggage.model.Passenger;

/**
 * The PassengerMenuController class represents a controller 
 * for managing passenger-related operations.
 * 
 * It handles HTTP requests related to passengers and communicates 
 * with the PassengerRepository to perform CRUD operations 
 * on the Passenger entities.
 * The API endpoints defined in this controller follow the '/passenger' base URL.
 * 
 * @author Auni Afeeqah
 *
 */
@Controller
public class PassengerMenuController {

	private String defaultURI = "http://localhost:8080/arriving/api/passengers";

	/**
	 * Retrieves a list of all passengers 
	 * and displays them on the "passenger" page.
	 * 
	 * @param model The model to attach the list of passengers.
	 * @return The view name for the "passenger" page.
	 */
	@GetMapping("/passenger/list")
	public String getPassengers(Model model) {
		// The URI for GET passengers
		String uri = "http://localhost:8080/arriving/api/passengers";

		// Get a list of passengers from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Passenger[]> response = 
				restTemplate.getForEntity(uri, Passenger[].class);

		// Parse JSON data to an array of objects
		Passenger[] passengers = response.getBody();

		// Convert the array to a list
		List<Passenger> passengerList = Arrays.asList(passengers);

		// Attach the list to the model as an attribute
		model.addAttribute("passengers", passengerList);

		// Return the view name for the "passenger" page
		return "passenger";
	}

	/**
	 * This method will update or add a passenger.
	 * 
	 * @param passenger The passenger object to be updated or added.
	 * @return The redirect URL to display a list of passengers.
	 */
	@RequestMapping("/passenger/save")
	public String updatePassenger(@ModelAttribute Passenger passenger) {
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Create request body
		HttpEntity<Passenger> request = new HttpEntity<Passenger>(passenger);

		String passengerResponse = "";

		if (passenger.getPassengerID() > 0) {
			// This block will update the existing passenger

			// Send request as PUT
			restTemplate.put("http://localhost:8080/arriving/api/passengers", 
					request, Passenger.class);
		} else {
			// This block will add a new passenger

			// Send request as POST
			passengerResponse = 
					restTemplate.postForObject("http://localhost:"
							+ "8080/arriving/api/passengers", 
							request,String.class);
		}

		System.out.println(passengerResponse);

		// Redirect request to display a list of passengers
		return "redirect:/passenger/list";
	}

	/**
	 * This method gets a passenger by its ID and displays it 
	 * on the "passengerinfo" page.
	 * 
	 * @param PassengeR The ID of the passenger to retrieve.
	 * @param model     The model to attach the passenger data.
	 * @return The view name for the "passengerinfo" page.
	 */
	@GetMapping("/passenger/{PassengeR}")
	public String getPassenger(@PathVariable Integer PassengeR, Model model) {
		String pageTitle = "New Passenger Details";
		Passenger passenger = new Passenger();

		// This block gets the passenger to be updated
		if (PassengeR > 0) {
			// Generate new URI and append PassengerId to it
			String uri = defaultURI + "/" + PassengeR;

			// Get the passenger detail from the web service
			RestTemplate restTemplate = new RestTemplate();
			passenger = restTemplate.getForObject(uri, Passenger.class);

			// Give a new title to the page
			pageTitle = "Edit Passenger Details";
		}

		// Get a list of flights from the web service
		RestTemplate restTemplateFlight = new RestTemplate();
		ResponseEntity<Flight[]> responseFlight = 
				restTemplateFlight.getForEntity("http://localhost:"
						+ "8080/arriving/api/flights", Flight[].class);

		// Parse the array to a list object
		List<Flight> flightList = Arrays.asList(responseFlight.getBody());

		// Attach values to pass to the front end
		model.addAttribute("passengers", passenger);
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("flights", flightList);

		return "passengerinfo";
	}
}
