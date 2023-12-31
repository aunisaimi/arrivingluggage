package arriving.luggage.flight.arrivingluggage.controller;


import java.util.List;
import java.util.Arrays;
import java.util.Map;


import org.springframework.http.HttpEntity;


import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

//import arriving.luggage.flight.arrivingluggage.model.Checkpoint2;
import arriving.luggage.flight.arrivingluggage.model.Flight;


@Controller

public class FlightMENUController
{

private String defaultURI = "http://localhost:8080/arriving/api/flights";
	
	@GetMapping("/flight/list")
	public String getFlight(Model model)
	{
		// The URI to GET the checkpoint1
		String uri =  "http://localhost:8080/arriving/api/flights";
		
		// get a list of checkpoint1 from web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Flight[]> response = restTemplate.getForEntity(uri, Flight[].class);
		
		// parse a JSON data to array of object
		Flight flights[] = response.getBody();
		
		// parse an array to list object
		List<Flight> flightList = Arrays.asList(flights);
		
		// Attach a list to model as attribute
		// this will be for the front end
		model.addAttribute("flight", flightList);
		
		return "flight";
		
		
		
	}
	
	/**
	 * This method will update or add flight
	 * 
	 * @param flights
	 * @return
	 * 
	 */
	
	@RequestMapping("/flight/save")
	public String updateFlight(@ModelAttribute Flight flight)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create a request Body
		HttpEntity<Flight> request = new HttpEntity<Flight>(flight);
		
		String flightResponse = " ";
		
		if (flight.getFlightId() > 0)
		{
			// This block adds new Flight
			
			// send request as PUT
			restTemplate.put(defaultURI, request, Flight.class);
		}
		else
		{
			//This block add a new flight
			
			// Send request as POST
			flightResponse = restTemplate.postForObject(
					defaultURI, request, String.class);
		}
		
		System.out.println(flightResponse);
		
		// Redirect request to display a list of flight
		return "redirect:/flight/list";
	}
	
	/**
	 * This method gets a flight
	 * 
	 * @param FlightId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/flight/{FlightId}")
	public String getFlight (@PathVariable Integer FlightId, Model model)
	{
		String pageTitle = "New Flight";
		Flight flight = new Flight();
		
		// This block gets flight to be updated
		if(FlightId > 0) {
			
			//Generate new URI and append Flight to it
			String uri = defaultURI + "/" + FlightId;
			
			//Get a Checkpoint1 from web service
			RestTemplate restTemplate = new RestTemplate();
			flight = restTemplate.getForObject(uri, Flight.class);
			
			// New title to the page
			pageTitle = "Edit Flight";
		}
		
		//Attach the value from db to pass to front end
		model.addAttribute("flight",flight);
		model.addAttribute("pageTitle",pageTitle);
		
		return "flightinfo";
		
		
		
	}
	
	/**
	 * This method deletes a flight
	 * 
	 * @param FlightId
	 * @return
	 */
	
	@RequestMapping("/flight/delete/{FlightId}")
	public String deleteFlight (@PathVariable Integer FlightId)
	{
		//Generate new URI
		String uri = defaultURI + "/{FlightId}";
		
		//Send a DELETE request and attach the value of flight into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Checkpoint2Id", (FlightId)));
		
		return "redirect:/flight/list";
	}
}
