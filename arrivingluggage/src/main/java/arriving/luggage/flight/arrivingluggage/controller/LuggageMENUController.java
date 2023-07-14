package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;
import java.util.Arrays;
import java.util.Map;


import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import arriving.luggage.flight.arrivingluggage.model.Luggage;
//import arriving.luggage.flight.arrivingluggage.model.Flight;
//import arriving.luggage.flight.arrivingluggage.model.Passenger;


@Controller
public class Luggagemenucontroller 
{
	private String defaultURI = "http://localhost:8080/arriving/api/luggages";
	
	@GetMapping("/luggage/list")
	public String getLuggage(Model model)
	{
		//the URI to GET luggage
		String uri = "http://localhost:8080/arriving/api/luggages";
		
		// GEt a list order types from, the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = restTemplate.getForEntity(uri, Luggage[].class);
		
		//parse JSON data to array of object
		Luggage luggages[] = response.getBody();
		
		// parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggages);
		
		// Attach a list to model as attribute
		
		model.addAttribute("luggages", luggageList);
		
		//Returning to HTML file
		return "luggage";
		
	}
	
	
	
	/**
	 * This method gets an luggage
	 * 
	 * @param LuggagE
	 * @param model
	 * @return
	 */
	@GetMapping("/luggage/{LuggagE}")
	public String getLuggage (@PathVariable Integer LuggagE, Model model) {
		
		String pageTitle = "New Luggage";
		Luggage luggage = new Luggage();
		
		// This block get luggage to be updated
		if (LuggagE > 0) {

			// Generate new URI and append LuggageId to it
			String uri = defaultURI + "/" + LuggagE;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			luggage = restTemplate.getForObject(uri, Luggage.class);
			
			//Give a new title to the page
			pageTitle = "Edit Luggage";
			
			
		}
		
		/*RestTemplate restTemplateFlight = new RestTemplate();
		ResponseEntity<Flight[]> responseFlight = 
				restTemplateFlight.getForEntity("http://localhost:8080/luggagehandling/api/flights", Flight[].class);
		
		Flight flightArray[] = responseFlight.getBody();	
		
		// Parse an array to a list object
		List<Flight> flightList = Arrays.asList(flightArray);
		
		
		RestTemplate restTemplatePassenger = new RestTemplate();
		ResponseEntity<Passenger[]> responsePassenger = 
				restTemplatePassenger.getForEntity("http://localhost:8080/luggagehandling/api/passengers", Passenger[].class);
		
		Passenger passengerArray[] = responsePassenger.getBody();	
		
		// Parse an array to a list object
		List<Passenger> passengerList = Arrays.asList(passengerArray);
		
		*/
		
		
		// Attach value to pass to front end
		
		model.addAttribute("luggages", luggage);
		//model.addAttribute("flight", flightList);
		//model.addAttribute("passenger", passengerList);
		model.addAttribute("pageTitle", pageTitle);
		
		return "luggageinfo";
			
	}
	


}
