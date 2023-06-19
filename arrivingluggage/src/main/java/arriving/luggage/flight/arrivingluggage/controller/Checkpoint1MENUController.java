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


@Controller
public class Checkpoint1MENUController
{
	private String defaultURI = "http://localhost:8080/arriving/api/checkpoint1s";
	
	@GetMapping("/checkpoint1/list")
	public String getCheckpoint1(Model model)
	{
		// The URI to GET the checkpoint1
		String uri =  "http://localhost:8080/arriving/api/checkpoint1s";
		
		// get a list of checkpoint1 from web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint1[]> response = restTemplate.getForEntity(uri, Checkpoint1[].class);
		
		// parse a JSON data to array of object
		Checkpoint1 checkpoint1s[] = response.getBody();
		
		// parse an array to list object
		List<Checkpoint1> checkpoint1List = Arrays.asList(checkpoint1s);
		
		// Attach a list to model as attribute
		// this will be for the front end
		model.addAttribute("checkpoint1s", checkpoint1List);
		
		return "checkpoint1";
		
		
		
	}
	
	/**
	 * This method will update or add Checkpoint1
	 * 
	 * @param checkpoint1s
	 * @return
	 * 
	 */
	
	@RequestMapping("/checkpoint1/save")
	public String updateCheckpoint1(@ModelAttribute Checkpoint1 checkpoint1)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create a request Body
		HttpEntity<Checkpoint1> request = new HttpEntity<Checkpoint1>(checkpoint1);
		
		String checkpoint1Response = " ";
		
		if (checkpoint1.getCheckpoint1Id() > 0)
		{
			// This block adds new checkpoint
			
			// send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint1.class);
		}
		else
		{
			//This block add a new Checkpoint1
			
			// Send request as POST
			checkpoint1Response = restTemplate.postForObject(
					defaultURI, request, String.class);
		}
		
		System.out.println(checkpoint1Response);
		
		// Redirect request to display a list of checkpoint1
		return "redirect:/checkpoint1/list";
	}
	
	/**
	 * This method gets a checkpoint1
	 * 
	 * @param Checkpoint1Id
	 * @param model
	 * @return
	 */
	
	@GetMapping("/checkpoint1/{Checkpoint1Id}")
	public String getCheckpoint1 (@PathVariable Integer Checkpoint1Id, Model model)
	{
		String pageTitle = "New Checkpoint1";
		Checkpoint1 checkpoint1 = new Checkpoint1();
		
		// This block gets Checkpoint1 to be updated
		if(Checkpoint1Id > 0) {
			
			//Generate new URI and append CheckpointId to it
			String uri = defaultURI + "/" + Checkpoint1Id;
			
			//Get a Checkpoint1 from web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint1 = restTemplate.getForObject(uri, Checkpoint1.class);
			
			// New title to the page
			pageTitle = "Edit Checkpoint1";
		}
		
		//Attach the value from db to pass to front end
		model.addAttribute("checkpoint1s",checkpoint1);
		model.addAttribute("pageTitle",pageTitle);
		
		return "checkpoint1info";
		
		
		
	}
	
	/**
	 * This method deletes a checkpoint1
	 * 
	 * @param Checkpoint1Id
	 * @return
	 */
	
	@RequestMapping("/checkpoint1/delete/{Checkpoint1Id}")
	public String deleteCheckpoint1 (@PathVariable Integer Checkpoint1Id)
	{
		//Generate new URI
		String uri = defaultURI + "/{Checkpoint1Id}";
		
		//Send a DELETE request and attach the value of Checkpoint1Id into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Checkpoint1Id", Integer.toString(Checkpoint1Id)));
		
		return "redirect:/chekcpoint1/list";
	}
	
}
