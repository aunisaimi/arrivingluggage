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


import arriving.luggage.flight.arrivingluggage.model.Checkpoint4;


@Controller
public class Checkpoint4MENUController
{
	
	private String defaultURI = "http://localhost:8080/arriving/api/checkpoint4s";
	
	@GetMapping("/checkpoint4/list")
	public String getCheckpoint4(Model model)
	{
		// The URI to GET the checkpoint4
		String uri =  "http://localhost:8080/arriving/api/checkpoint4s";
		
		// get a list of checkpoint4 from web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint4[]> response = restTemplate.getForEntity(uri, Checkpoint4[].class);
		
		// parse a JSON data to array of object
		Checkpoint4 checkpoint4s[] = response.getBody();
		
		// parse an array to list object
		List<Checkpoint4> checkpoint4List = Arrays.asList(checkpoint4s);
		
		// Attach a list to model as attribute
		// this will be for the front end
		model.addAttribute("checkpoint4s", checkpoint4List);
		
		return "checkpoint4";
		
		
		
	}
	
	/**
	 * This method will update or add Checkpoint4
	 * 
	 * @paramcheckpoint4
	 * @return
	 * 
	 */
	
	@RequestMapping("/checkpoint4/save")
	public String updateCheckpoint4(@ModelAttribute Checkpoint4 checkpoint4)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create a request Body
		HttpEntity<Checkpoint4> request = new HttpEntity<Checkpoint4>(checkpoint4);
		
		String checkpoint4Response = " ";
		
		if (checkpoint4.getCheckPoint4Id() > 0)
		{
			// This block adds new checkpoint
			
			// send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint4.class);
		}
		else
		{
			//This block add a new Checkpoint4
			
			// Send request as POST
			checkpoint4Response = restTemplate.postForObject(
					defaultURI, request, String.class);
		}
		
		System.out.println(checkpoint4Response);
		
		// Redirect request to display a list of checkpoint4
		return "redirect:/checkpoint4/list";
	}
	
	/**
	 * This method gets a checkpoint4
	 * 
	 * @paramCheckPointId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/checkpoint4/{CheckPoint4Id}")
	public String getCheckpoint4 (@PathVariable Integer CheckPoint4Id, Model model)
	{
		String pageTitle = "New Checkpoint 4";
		Checkpoint4 checkpoint4 = new Checkpoint4();
		
		// This block gets Checkpoint4 to be updated
		if(CheckPoint4Id > 0) {
			
			//Generate new URI and append CheckpointId to it
			String uri = defaultURI + "/" + CheckPoint4Id;
			
			//Get a Checkpoint4 from web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint4 = restTemplate.getForObject(uri, Checkpoint4.class);
			
			// New title to the page
			pageTitle = "Edit Checkpoint 4";
		}
		
		//Attach the value from db to pass to front end
		model.addAttribute("checkpoint4s",checkpoint4);
		model.addAttribute("pageTitle",pageTitle);
		
		return "checkpoint4info";
		
		
		
	}
	
	/**
	 * This method deletes a checkpoint4
	 * 
	 * @param CheckPointId
	 * @return
	 */
	
	@RequestMapping("/checkpoint4/delete/{CheckPoint4Id}")
	public String deleteCheckpoint4 (@PathVariable Integer CheckPoint4Id)
	{
		//Generate new URI
		String uri = defaultURI + "/{CheckPoint4Id}";
		
		//Send a DELETE request and attach the value of Checkpoint4Id into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("CheckPoint4Id",(CheckPoint4Id)));
		
		return "redirect:/chekcpoint4/list";
	}
	
}