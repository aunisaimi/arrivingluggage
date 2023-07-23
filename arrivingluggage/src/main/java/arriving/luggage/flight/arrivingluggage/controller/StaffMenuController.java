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

import arriving.luggage.flight.arrivingluggage.model.Staff;


/**
 * 
 * @author Anis Sabrina
 *
 */

@Controller
public class StaffMenuController 
{
	@GetMapping("/staff/list")
	public String getStaff(Model model)
	{
		// The URI for GET Staff
		String uri = "http://localhost:8080/arriving/api/staffs";
		
		//Get a list of Truck from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<Staff[]> response = 
				restTemplate.getForEntity(uri, Staff[].class);
		
		// Parse JSON data to array of object
		Staff staffs[] = response.getBody();
		
		// Parse an array to a list object
		List<Staff> staffList = Arrays.asList(staffs);
		
		//Attach list to model as attributes
		model.addAttribute("staffs", staffList);
		
		return "staff";
		
	}
}
