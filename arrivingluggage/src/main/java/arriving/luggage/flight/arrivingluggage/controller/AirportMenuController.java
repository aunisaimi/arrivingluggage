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
import arriving.luggage.flight.arrivingluggage.model.Flight;



@Controller
public class AirportMenuController
{

	@GetMapping("/airport/list")
	public String getAirport(Model model)
	{
		// The URI to GET the airport
		String uri =  "http://localhost:8080/arriving/api/airports";
		
		// get a list of airport from web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Airport[]> response = 
				restTemplate.getForEntity(uri, Airport[].class);
		
		// parse a JSON data to array of object
		Airport airports[] = response.getBody();
		
		// parse an array to list object
		List<Airport> airportList = Arrays.asList(airports);
		
		// Attach a list to model as attribute
		// this will be for the front end
		model.addAttribute("airports", airportList);
		
		return "airport";
		
		
		
	}
	
	

}
