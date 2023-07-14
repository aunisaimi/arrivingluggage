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


import arriving.luggage.flight.arrivingluggage.model.Checkpoint3;


@Controller
public class Checkpoint3MENUController
{
	
	private String defaultURI = "http://localhost:8080/arriving/api/checkpoint3s";
	
	@GetMapping("/checkpoint3/list")
	public String getCheckpoint3(Model model)
	{
		// The URI to GET the checkpoint3
		String uri =  "http://localhost:8080/arriving/api/checkpoint3s";
		
		// get a list of checkpoint3 from web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint3[]> response = restTemplate.getForEntity(uri, Checkpoint3[].class);
		
		// parse a JSON data to array of object
		Checkpoint3 checkpoint3s[] = response.getBody();
		
		// parse an array to list object
		List<Checkpoint3> checkpoint3List = Arrays.asList(checkpoint3s);
		
		// Attach a list to model as attribute
		// this will be for the front end
		model.addAttribute("checkpoint3s", checkpoint3List);
		
		return "checkpoint3";
		
		
		
	}
	
	/**
	 * This method will update or add Checkpoint3
	 * 
	 * @paramcheckpoint3
	 * @return
	 * 
	 */
	
	@RequestMapping("/checkpoint3/save")
	public String updateCheckpoint3(@ModelAttribute Checkpoint3 checkpoint3)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create a request Body
		HttpEntity<Checkpoint3> request = new HttpEntity<Checkpoint3>(checkpoint3);
		
		String checkpoint3Response = " ";
		
		if (checkpoint3.getCheckPoint3Id() > 0)
		{
			// This block adds new checkpoint
			
			// send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint3.class);
		}
		else
		{
			//This block add a new Checkpoint3
			
			// Send request as POST
			checkpoint3Response = restTemplate.postForObject(
					defaultURI, request, String.class);
		}
		
		System.out.println(checkpoint3Response);
		
		// Redirect request to display a list of checkpoint3
		return "redirect:/checkpoint3/list";
	}
	
	/**
	 * This method gets a checkpoint3
	 * 
	 * @paramCheckPointId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/checkpoint3/{CheckPoint3Id}")
	public String getCheckpoint3 (@PathVariable Integer CheckPoint3Id, Model model)
	{
		String pageTitle = "New Checkpoint 3";
		Checkpoint3 checkpoint3 = new Checkpoint3();
		
		// This block gets Checkpoint3 to be updated
		if(CheckPoint3Id > 0) {
			
			//Generate new URI and append CheckpointId to it
			String uri = defaultURI + "/" + CheckPoint3Id;
			
			//Get a Checkpoint3 from web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint3 = restTemplate.getForObject(uri, Checkpoint3.class);
			
			// New title to the page
			pageTitle = "Edit Checkpoint 3";
		}
		
		//Attach the value from db to pass to front end
		model.addAttribute("checkpoint3s",checkpoint3);
		model.addAttribute("pageTitle",pageTitle);
		
		return "checkpoint3info";
		
		
		
	}
	
	/**
	 * This method deletes a checkpoint4
	 * 
	 * @param CheckPointId
	 * @return
	 */
	
	@RequestMapping("/checkpoint3/delete/{CheckPoint3Id}")
	public String deleteCheckpoint3 (@PathVariable Integer CheckPoint3Id)
	{
		//Generate new URI
		String uri = defaultURI + "/{CheckPoint3Id}";
		
		//Send a DELETE request and attach the value of Checkpoint3Id into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("CheckPoint3Id", Integer.toString(CheckPoint3Id)));
		
		return "redirect:/checkpoint3/list";
	}
	
}