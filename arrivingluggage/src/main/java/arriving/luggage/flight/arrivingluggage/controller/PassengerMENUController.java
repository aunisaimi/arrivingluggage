package arriving.luggage.flight.arrivingluggage.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;


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
		
		return "passengers";
		
	}
	
}
