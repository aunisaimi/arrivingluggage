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

import arriving.luggage.flight.arrivingluggage.model.Truck;


@Controller
public class Truckmenucontroller 
{
private String defaultURI = "http://localhost:8080/arriving/api/trucks";
	
	
	@GetMapping("/truck/list")
	public String getTruck(Model model)
	{
		// The URI for GET Truck
		String uri = "http://localhost:8080/arriving/api/trucks";
		
		//Get a list of Truck from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<Truck[]> response = 
				restTemplate.getForEntity(uri, Truck[].class);
		
		// Parse JSON data to array of object
		Truck trucks[] = response.getBody();
		
		// Parse an array to a list object
		List<Truck> truckList = Arrays.asList(trucks);
		
		//Attach list to model as attributes
		model.addAttribute("trucks", truckList);
		
		return "truck";
		
	}
	
	/**
	 * This method will update or add a truck 
	 * 
	 * @param truck
	 * @return
	 */
	
	@RequestMapping("/truck/save")
	public String updateTruck(@ModelAttribute Truck truck)
	{
		// here create a new RestTemplate 
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Truck> request = new HttpEntity<Truck>(truck);
		
		String truckResponse = "";
		
		if (truck.getTruckID()>0)
		{
			// this block will update new Truck and
			
			// send request as PUT
			
			restTemplate.put("http://localhost:8080/arriving/api/trucks", request, Truck.class);
			
			
		}
		
		else
		{
			// This block will add new Truck and
			
			// Send Request as POST
			truckResponse = restTemplate.postForObject("http://localhost:8080/arriving/api/trucks", request, String.class);
			
		}
		
		System.out.println(truckResponse);
		
		//Redirect request to display a list of truck
		return "redirect:/truck/list";
	}
	
	/**
	 * This method will get truck
	 * 
	 * @param Truck
	 * @param model
	 * @return
	 */
	
	@GetMapping("/truck/{TruckID}")
	public String getTruck (@PathVariable Integer TruckID, Model model)
	{
		String pageTitle = "New Truck Details";
		Truck truck1 = new Truck();
		
		//This block will get a Truck to be updated
		if(TruckID> 0)
		{
			
			// Generate new URI and append TruckId to it
			String uri = defaultURI + "/" + TruckID;
			
			// Get a passenger detail from web service
			RestTemplate restTemplate = new RestTemplate();
			truck1 = restTemplate.getForObject(uri, Truck.class);
			
			//Give new title to the page:
			pageTitle = "Edit Truck Details";
			
			
		}
		
		// Attach value to pass to front end
		model.addAttribute("trucks",truck1);
		model.addAttribute("pageTitle", pageTitle);
		
		return "truckinfo";
	}
	/*
	/**
	 * This method deletes a Truck
	 * 
	 * @param TruckId
	 * @return
	 */
	/*
	@RequestMapping("/truck/delete/{Truck}")
	public String deleteTruck(@PathVariable Integer truck)
	{
		
		// Generate new URI, similar to the mapping in TruckRESTController
		String uri = defaultURI + "/{Truck}";
		
		// Send a DELETE request and attach the value of TruckId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("truck", (truck)));
		
		return "redirect:/truck/list";
		
	}
	*/
}
