package arriving.luggage.flight.arrivingluggage.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import arriving.luggage.flight.arrivingluggage.model.Staff;


/**
 * The StaffMenuController class represents a controller 
 * for managing staff-related operations.
 * 
 * It handles HTTP requests related to staff and communicates 
 * with the StaffRepository to fetch staff details.
 * The API endpoints defined in this controller follow the '/staff' base URL.
 * 
 *@author Anis Sabrina
 *
 */
@Controller
public class StaffMenuController {

    /**
     * Retrieves a list of all staff members.
     * 
     * @param model The Model object to add attributes to 
     * for rendering on the view.
     * @return The view name for displaying staff details.
     */
    @GetMapping("/staff/list")
    public String getStaff(Model model) {
        // The URI for GET staff
        String uri = "http://localhost:8080/arriving/api/staffs";
        
        // Get a list of staff from the web service
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Staff[]> response = 
        		restTemplate.getForEntity(uri, Staff[].class);
        
        // Parse JSON data to an array of staff objects
        Staff staffs[] = response.getBody();
        
        // Parse the array to a list of staff objects
        List<Staff> staffList = Arrays.asList(staffs);
        
        // Attach the list of staffs to the model as attributes 
        //for rendering on the view
        model.addAttribute("staffs", staffList);
        
        // Return the view name for displaying staff details
        return "staff";
    }
}

