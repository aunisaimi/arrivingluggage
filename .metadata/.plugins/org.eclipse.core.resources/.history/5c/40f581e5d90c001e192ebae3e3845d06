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

@Controller
public class LuggageMENUController 
{
	private String defaultURI = "http://localhost:8080/arriving/api/luggages";
	
	@GetMapping("/luggage/list")
	public String getLuggage(Model model)
	{
		//the URI to GET luggage
		String uri = "http://localhost:8080/arriving/api/luggages";
		
		// GEt a list order types fro, the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = restTemplate.getForEntity(uri, Luggage[].class);
		
		//parse JSON data to array of object
		Luggage luggages[] = response.getBody();
		
		// parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggages);
		
		// Attach a list to model as attribute
		model.addAttribute("luggages", luggageList);
		
		return "luggage";
		
	}
	
	/**
	 * This method will update or add luggage
	 * 
	 * @param luggages
	 * @return
	 */
	
	@RequestMapping("/luggage/save")
	public String updateLuggage(@ModelAttribute Luggage luggage)
	{
		// Create a new RestTemplate
				RestTemplate restTemplate = new RestTemplate();
				
				// Create request body
				HttpEntity<Luggage> request =new HttpEntity<Luggage>(luggage);
				
				String luggageResponse = " ";
				
				if (luggage.getLuggageId() > 0)
				{
					// This block update an new luggage id and
					
					// Send request as PUT
					restTemplate.put(defaultURI, request, Luggage.class);
				}
				else
				{
					// This block add a new luggage
					
					// send request as POST
					luggageResponse = restTemplate.postForObject(
							defaultURI, request, String.class);
				}
				
				System.out.println(luggageResponse);
				
				// Redirect request to display a list of order type
				return "redirect:/luggage/list";
	}
	
	/**
	 * This method gets an luggage
	 * 
	 * @param LuggageId
	 * @param model
	 * @return
	 */
	@GetMapping("/luggage/{LuggageId}")
	public String getLuggage (@PathVariable Integer LuggageId, Model model) {
		
		String pageTitle = "New Luggage";
		Luggage luggage = new Luggage();
		
		// This block get luggage to be updated
		if (LuggageId > 0) {

			// Generate new URI and append LuggageId to it
			String uri = defaultURI + "/" + LuggageId;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			luggage = restTemplate.getForObject(uri, Luggage.class);
			
			//Give a new title to the page
			pageTitle = "Edit Luggage";
		}
		
		// Attach value to pass to front end
		//model.addAttribute("luggage", luggage);
		model.addAttribute("luggages", luggage);
		model.addAttribute("pageTitle", pageTitle);
		
		return "luggageinfo";
			
	}
	
	/**
	 * This method deletes an luggage
	 * 
	 * @param LuggageId
	 * @return
	 */
	@RequestMapping("/luggage/delete/{LuggageId}")
	public String deleteLuggage(@PathVariable Integer LuggageId)
	{
		// Generate new URI, similar to the mapping in LuggageRESTController
		String uri = defaultURI + "/{LuggageId}";
		
		// Send a DELETE request and attach the value of LuggageId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("LuggageId", Integer.toString(LuggageId)));
		
		return "redirect:/luggage/list";
	}
	

}
