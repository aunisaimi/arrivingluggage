package arriving.luggage.flight.arrivingluggage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;


import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.model.Passenger;


@Controller
public class PassengerMENUController
{
	
	private String defaultURI = "http://localhost:8080/arriving/api/passengers";
	
	
	@GetMapping("/passenger/list")
	public String getPassengers(Model model)
	{
		// The URI for GET passengers
		String uri = "http://localhost:8080/arriving/api/passengers";
		
		//Get a list of passengers from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<Passenger[]> response = restTemplate.getForEntity(uri, Passenger[].class);
		
		// Parse JSON data to array of object
		Passenger passengers[] = response.getBody();
		
		// Parse an array to a list object
		List<Passenger> passengerList = Arrays.asList(passengers);
		
		//Attach list to model as attributes
		model.addAttribute("passengers", passengerList);
		
		return "passenger";
		
	}
	
	/**
	 * This method will update or add a passenger 
	 * 
	 * @param passenger
	 * @return
	 */
	
	@RequestMapping("/passenger/save")
	public String updatePassenger(@ModelAttribute Passenger passenger)
	{
		// here create a new RestTemplate 
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Passenger> request = new HttpEntity<Passenger>(passenger);
		
		String passengerResponse = "";
		
		if (passenger.getPassengerId()>0)
		{
			// this block will update new passenger and
			
			// send request as PUT
			
			restTemplate.put(defaultURI, request, Passenger.class);
			
			
		}
		
		else
		{
			// This block will add new passenger and
			
			// Send Request as POST
			passengerResponse = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(passengerResponse);
		
		//Redirect request to display a list of passenger
		return "redirect:/passenger/list";
	}
	
	/**
	 * This method will get passenger
	 * 
	 * @param PassengerId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/passenger/{PassengerId}")
	public String getPassenger (@PathVariable Integer PassengerId, Model model)
	{
		String pageTitle = "New Passenger Details";
		Passenger passenger = new Passenger();
		
		//This block will get a passenger to be updated
		if(PassengerId > 0)
		{
			
			// Generate new URI and append PassengerId to it
			String uri = defaultURI + "/" + PassengerId;
			
			// Get a passenger detail from web service
			RestTemplate restTemplate = new RestTemplate();
			passenger = restTemplate.getForObject(uri, Passenger.class);
			
			//Give new title to the page:
			pageTitle = "Edit Passenger Details";
			
			
		}
		
		// Attach value to pass to front end
		model.addAttribute("passengers",passenger);
		model.addAttribute("pageTitle", pageTitle);
		
		return "passengerinfo";
	}
	
	/**
	 * This method deletes a passenger
	 * 
	 * @param PassengerId
	 * @return
	 */
	
	@RequestMapping("/passenger/delete/{PassengerId}")
	public String deletePassenger(@PathVariable Integer PassengerId)
	{
		
		// Generate new URI, similar to the mapping in PassengerRESTController
		String uri = defaultURI + "/{PassengerId}";
		
		// Send a DELETE request and attach the value of PassengerId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("PassengerId", Integer.toString(PassengerId)));
		
		return "redirect:/passenger/list";
		
	}
	
	
	
	
	
	
	
	
	
	
}
