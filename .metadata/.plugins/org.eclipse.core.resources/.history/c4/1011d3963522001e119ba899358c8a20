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

//import arriving.luggage.flight.arrivingluggage.model.Checkpoint2;
import arriving.luggage.flight.arrivingluggage.model.TrackingSheet;
//import arriving.luggage.flight.arrivingluggage.model.Checkpoint1;
//import arriving.luggage.flight.arrivingluggage.model.Checkpoint3;
//import arriving.luggage.flight.arrivingluggage.model.Luggage;


@Controller
public class TrackingsheetMENUController 
{
private String defaultURI = "http://localhost:8080/arriving/api/trackingsheets";
	
	
	@GetMapping("/trackingsheet/list")
	public String getTrackingSheets(Model model)
	{
		// The URI for GET trackingsheet
		String uri = "http://localhost:8080/arriving/api/trackingsheets";
		
		//Get a list of passengers from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<TrackingSheet[]> response = restTemplate.getForEntity(uri, TrackingSheet[].class);
		
		// Parse JSON data to array of object
		TrackingSheet trackingsheets[] = response.getBody();
		
		// Parse an array to a list object
		List<TrackingSheet> trackingsheetList = Arrays.asList(trackingsheets);
		
		//Attach list to model as attributes
		model.addAttribute("trackingsheets", trackingsheetList);
		
		return "trackingsheet";
		
	}
	

	/**
	 * This method will update or add a trackingsheet 
	 * 
	 * @param trackingsheet
	 * @return
	 */
	
	@RequestMapping("/trackingsheet/save")
	public String updateTrackingSheet(@ModelAttribute TrackingSheet trackingsheet)
	{
		// here create a new RestTemplate 
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<TrackingSheet> request = new HttpEntity<TrackingSheet>(trackingsheet);
		
		String trackingsheetResponse = "";
		
		if (trackingsheet.getTrackingsheetID()>0)
		{
			// this block will update new trackingsheet and
			
			// send request as PUT
			
			restTemplate.put("http://localhost:8080/arriving/api/trackingsheets", request, TrackingSheet.class);
			
			
		}
		
		else
		{
			// This block will add new passenger and
			
			// Send Request as POST	
			trackingsheetResponse = restTemplate.postForObject("http://localhost:8080/arriving/api/trackingsheets", request, String.class);
			
		}
		
		System.out.println(trackingsheetResponse);
		
		//Redirect request to display a list of TrackingSheet
		return "redirect:/trackingsheet/list";
	}
	
	/**
	 * This method will get trackingsheet
	 * 
	 * @param TrackingSheetId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/trackingsheet/{trackingsheetID}")
	public String getTrackingSheet (@PathVariable Integer trackingsheetID, Model model)
	{
		String pageTitle = "New TrackingSheet Details";
		TrackingSheet trackingsheet = new TrackingSheet();
		
		//This block will get a TrackingSheet to be updated
		if(trackingsheetID > 0)
		{
			
			// Generate new URI and append PassengerId to it
			String uri = defaultURI + "/" + trackingsheetID;
			
			// Get a passenger detail from web service
			RestTemplate restTemplate = new RestTemplate();
			trackingsheet = restTemplate.getForObject(uri, TrackingSheet.class);
			
			//Give new title to the page:
			pageTitle = "Edit TrackingSheet Details";
			
			
		}
		/*
		RestTemplate restTemplateLuggage = new RestTemplate();
	    ResponseEntity<Luggage[]> luggageResponse =
	            restTemplateLuggage.getForEntity("http://localhost:8080/projectapp/api/luggages", Luggage[].class);

	    Luggage luggage[] = luggageResponse.getBody();

	    // Parse an array to a list object
	    List<Luggage> luggageList = Arrays.asList(luggage);


	    RestTemplate restTemplateCheckpoint1 = new RestTemplate();
	    ResponseEntity<Checkpoint1[]> checkpoint1Response =
	            restTemplateCheckpoint1.getForEntity("http://localhost:8080/projectapp/api/checkpoint1s", Checkpoint1[].class);

	    Checkpoint1 checkpoint1[] = checkpoint1Response.getBody();

	    // Parse an array to a list object
	    List<Checkpoint1> checkpoint1List = Arrays.asList(checkpoint1);
		
	    RestTemplate restTemplateCheckpoint2 = new RestTemplate();
	    ResponseEntity<Checkpoint2[]> checkpoint2Response =
	            restTemplateCheckpoint2.getForEntity("http://localhost:8080/projectapp/api/checkpoint2s", Checkpoint2[].class);

	    Checkpoint2 checkpoint2[] = checkpoint2Response.getBody();

	    // Parse an array to a list object
	    List<Checkpoint2> checkpoint2List = Arrays.asList(checkpoint2);
	    
	    RestTemplate restTemplateCheckpoint3 = new RestTemplate();
	    ResponseEntity<Checkpoint3[]> checkpoint3Response =
	            restTemplateCheckpoint3.getForEntity("http://localhost:8080/projectapp/api/checkpoint3s", Checkpoint3[].class);

	    Checkpoint3 checkpoint3[] = checkpoint3Response.getBody();

	    // Parse an array to a list object
	    List<Checkpoint3> checkpoint3List = Arrays.asList(checkpoint3);
	    */
		
		// Attach value to pass to front end
		model.addAttribute("trackingsheets",trackingsheet);
		/*
		model.addAttribute("luggages",luggageList);
		model.addAttribute("checkpoint1s",checkpoint1List);
		model.addAttribute("checkpoint2s",checkpoint2List);
		model.addAttribute("checkpoint3s",checkpoint3List);
		*/
		model.addAttribute("pageTitle", pageTitle);
		
		return "trackingsheetinfo";
	}
	
	/**
	 * This method deletes a trackingsheet
	 * 
	 * @param TrackingSheetId
	 * @return
	 */
	
	@RequestMapping("/trackingsheet/delete/{trackingsheetID}")
	public String deleteTrackingSheet(@PathVariable Integer trackingsheetID)
	{
		
		// Generate new URI, similar to the mapping in TrackingsheetRESTController
		String uri = defaultURI + "/{trackingsheetID}";
		
		// Send a DELETE request and attach the value of TrackingSheetId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("trackingsheetID", Integer.toString(trackingsheetID)));
		
		return "redirect:/trackingsheet/list";
		
	}
}