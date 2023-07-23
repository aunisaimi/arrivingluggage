package arriving.luggage.flight.arrivingluggage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;


//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.model.Airport;



@Controller
public class AirportMenuController
{
	@GetMapping("/airport/list")
	public String getAirport(Model model)
	{
		// The URI for GET Airport
		String uri = "http://localhost:8080/arriving/api/airports";
		
		//Get a list of Airport from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<Airport[]> response = 
				restTemplate.getForEntity(uri, Airport[].class);
		
		// Parse JSON data to array of object
		Airport airports[] = response.getBody();
		
		// Parse an array to a list object
		List<Airport> airportList = Arrays.asList(airports);
		
		//Attach list to model as attributes
		model.addAttribute("airports", airportList);
		
		return "airport";
		
	}

}
