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

import arriving.luggage.flight.arrivingluggage.model.Checkpoint1;
import arriving.luggage.flight.arrivingluggage.model.Checkpoint2;


@Controller
public class Checkpoint2MENUController 
{
private String defaultURI = "http://localhost:8080/arriving/api/checkpoint2s";
	
	@GetMapping("/checkpoint2/list")
	public String getCheckpoint1(Model model)
	{
		// The URI to GET the checkpoint1
		String uri =  "http://localhost:8080/arriving/api/checkpoint2s";
		
		// get a list of checkpoint1 from web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint2[]> response = restTemplate.getForEntity(uri, Checkpoint2[].class);
		
		// parse a JSON data to array of object
		Checkpoint2 checkpoint2s[] = response.getBody();
		
		// parse an array to list object
		List<Checkpoint2> checkpoint2List = Arrays.asList(checkpoint2s);
		
		// Attach a list to model as attribute
		// this will be for the front end
		model.addAttribute("checkpoint2s", checkpoint2List);
		
		return "checkpoint2";
		
		
		
	}
	
	/**
	 * This method will update or add Checkpoint2
	 * 
	 * @param checkpoint2s
	 * @return
	 * 
	 */
	
	@RequestMapping("/checkpoint2/save")
	public String updateCheckpoint2(@ModelAttribute Checkpoint2 checkpoint2)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create a request Body
		HttpEntity<Checkpoint2> request = new HttpEntity<Checkpoint2>(checkpoint2);
		
		String checkpoint2Response = " ";
		
		if (checkpoint2.getCheckPoint2Id() > 0)
		{
			// This block adds new checkpoint
			
			// send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint2.class);
		}
		else
		{
			//This block add a new Checkpoint1
			
			// Send request as POST
			checkpoint2Response = restTemplate.postForObject(
					defaultURI, request, String.class);
		}
		
		System.out.println(checkpoint2Response);
		
		// Redirect request to display a list of checkpoint2
		return "redirect:/checkpoint2/list";
	}
	
	/**
	 * This method gets a checkpoint
	 * 
	 * @param Checkpoint2Id
	 * @param model
	 * @return
	 */
	
	@GetMapping("/checkpoint2/{CheckPoint2Id}")
	public String getCheckpoint2 (@PathVariable Integer CheckPoint2Id, Model model)
	{
		String pageTitle = "New Checkpoint2";
		Checkpoint2 checkpoint2 = new Checkpoint2();
		
		// This block gets Checkpoint2 to be updated
		if(CheckPoint2Id > 0) {
			
			//Generate new URI and append Checkpoint2Id to it
			String uri = defaultURI + "/" + CheckPoint2Id;
			
			//Get a Checkpoint1 from web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint2 = restTemplate.getForObject(uri, Checkpoint2.class);
			
			// New title to the page
			pageTitle = "Edit Checkpoint2";
		}
		
		//Attach the value from db to pass to front end
		model.addAttribute("checkpoint2s",checkpoint2);
		model.addAttribute("pageTitle",pageTitle);
		
		return "checkpoint2info";
		
		
		
	}
	
	/**
	 * This method deletes a checkpoint2
	 * 
	 * @param Checkpoint2Id
	 * @return
	 */
	
	@RequestMapping("/checkpoint2/delete/{CheckPoint2Id}")
	public String deleteCheckpoint2 (@PathVariable Integer CheckPoint2Id)
	{
		//Generate new URI
		String uri = defaultURI + "/{CheckPoint2Id}";
		
		//Send a DELETE request and attach the value of CheckPoint1Id into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("CheckPoint2Id", Integer.toString(CheckPoint2Id)));
		
		return "redirect:/chekcpoint2/list";
	}
	
}
