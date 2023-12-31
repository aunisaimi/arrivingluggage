package arriving.luggage.flight.arrivingluggage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.model.Checkpoint;
import arriving.luggage.flight.arrivingluggage.model.TrackingSheet;
import arriving.luggage.flight.arrivingluggage.model.ConveyorLane;
import arriving.luggage.flight.arrivingluggage.model.Luggage;
import arriving.luggage.flight.arrivingluggage.model.Staff;
import arriving.luggage.flight.arrivingluggage.model.Truck;

/**
 * This class is a Spring MVC controller responsible 
 * for handling HTTP requests related to tracking sheets.
 * 
 * It provides methods to retrieve, create, and display 
 * tracking sheet information using RESTful web services.
 * 
 * The controller communicates with the backend service to fetch 
 * and store data related to tracking sheets.
 * 
 * The methods in this class are mapped to specific URLs, 
 * and each method serves a particular purpose in the web application.
 * 
 * The tracking sheet data is fetched from and stored in a web service 
 * using the RestTemplate class.
 * 
 * The controller also adds attributes to the Model 
 * to pass data to the view templates for rendering in HTML pages.
 * 
 * This class is part of the "Arriving Luggage" web application.
 *
 * @author Auni Afeeqah
 */

@Controller
public class TrackingsheetMenuController {
private String defaultURI = "http://localhost:8080/arriving/api/trackingsheets";
	
	@GetMapping("/trackingsheet/list")
	public String getTrackingSheets(Model model)
	{
		// The URI for GET trackingsheet
		String uri = "http://localhost:8080/arriving/api/trackingsheets";
		
		//Get a list of passengers from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<TrackingSheet[]> response = 
				restTemplate.getForEntity(uri, TrackingSheet[].class);
		
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
	public String updateTrackingSheet
	(@ModelAttribute TrackingSheet trackingsheet){
		// here create a new RestTemplate 
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<TrackingSheet> request =
				new HttpEntity<TrackingSheet>(trackingsheet);
		
		String trackingsheetResponse = "";
		
		if (trackingsheet.getTrackingsheetID()>0){
			// this block will update new trackingsheet and
			// send request as PUT
			
			restTemplate.put("http://localhost:8080/arriving/api/trackingsheets", 
					request, TrackingSheet.class);	
		}
		else{
			// This block will add new passenger and
			// Send Request as POST	
			trackingsheetResponse = restTemplate.postForObject
					("http://localhost:8080/arriving/api/trackingsheets", 
							request, String.class);
		}
		
		System.out.println(trackingsheetResponse);

		//Redirect request to display a list of TrackingSheet
		return "redirect:/trackingsheet/list";
	}
	
	/**
	 * This method will get a request to retrieve info about checkpoint 1 of
	 * a specific tracking sheet. 
	 * Retrieve checkpoint information from web service
	 * add the retrieved data into model and pass into checkpoint1info.html
	 * view
	 * 
	 * @param TrackingSheetId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/trackingsheet/checkpoint1/{trackingsheetID}")
	public String getCheckpoint1 (@PathVariable int trackingsheetID, 
									Model model){
		
		String pageTitle = "Checkpoint 1";
		TrackingSheet trackingsheet1 = new TrackingSheet();
		
		
		//This will get a TrackingSheet to be updated
		if(trackingsheetID > 0)
		{
			
			// Generate new URI and append PassengerId to it
			String uri = defaultURI + "/" + trackingsheetID;
			
			// Get a checkpoint1 detail from web service
			RestTemplate restTracking = new RestTemplate();
			trackingsheet1 = restTracking.getForObject(uri, TrackingSheet.class);
			
			//Give new title to the page:
			pageTitle = "Edit Checkpoint";	
		}
		
		//Get the checkpoint info from web service
		RestTemplate checkpointREST = new RestTemplate();
		ResponseEntity<Checkpoint[]> responseCheckpoint =
				checkpointREST.getForEntity("http://localhost:8080/arriving"
						+ "/api/checkpoints", Checkpoint[].class);
		
		//Parse JSON data to an array object
		Checkpoint checkpointArray[] = responseCheckpoint.getBody();
		
		//Parse Array to a list object
		List<Checkpoint> checkpointList = Arrays.asList(checkpointArray);
		
		// Get the luggage unit info from web service
		RestTemplate restTemplateTruck = new RestTemplate();
		ResponseEntity<Truck[]> responseTruck = 
				restTemplateTruck.getForEntity("http://localhost:8080"
						+ "/arriving/api/trucks", Truck[].class);
	
		Truck truckArray[] = responseTruck.getBody();
		
		//parse Array to a list object
		List<Truck> truckList = Arrays.asList(truckArray);
		
		RestTemplate restTemplateluggage = new RestTemplate();
		ResponseEntity<Luggage[]> responseLuggage = 
				restTemplateluggage.getForEntity("http://localhost:8080"
						+ "/arriving/api/luggages", Luggage[].class);
		
		Luggage luggageArray[] = responseLuggage.getBody();
		
		//parse Array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
		
		// Attach values to the model
		model.addAttribute("trackingsheet1",trackingsheet1);
		model.addAttribute("checkpoints",checkpointList);
		model.addAttribute("trucks",truckList);
		model.addAttribute("luggages",luggageList);
		model.addAttribute("pageTitle", pageTitle);
		
		return "checkpoint1info";	
	}
	
	/**
	 * Handles a POST request to save checkpoint 1 info of tracking sheet
	 * Sends a HTTP POST request to the web service to save checkpoint 2 info
	 * 
	 * redirects to the checkpoint 2 page
	 * 
	 */
	@RequestMapping("/trackingsheet/checkpoint1/save")
	public String insertTrackingSheetCheckpoint1 (@ModelAttribute TrackingSheet
			trackingsheet) {
		RestTemplate restTemplatecp1 = new RestTemplate();
		HttpEntity<TrackingSheet> request = 
				new HttpEntity<TrackingSheet>(trackingsheet);
		
		String trackingsheetCheckpoint1Response = "";
		
		String uri = defaultURI + "/checkpoint1/save";
		
		if (trackingsheet.getTrackingsheetID()>0){
			restTemplatecp1.put(defaultURI, request, TrackingSheet.class);
			
		}
		else{
			trackingsheetCheckpoint1Response =
					restTemplatecp1.postForObject(uri, request, String.class);
		}
		
		System.out.println(trackingsheetCheckpoint1Response);
		
		return "redirect:/trackingsheet/checkpoint2/0";
	}
	
	/**
	 * This method will get a request to retrieve info about checkpoint 2 of
	 * a specific tracking sheet. 
	 * Retrieve checkpoint information from web service
	 * add the retrieved data into model and pass into checkpoint1info.html
	 * view
	 * 
	 * @param TrackingSheetId
	 * @param model
	 * @return
	 */
	@GetMapping("/trackingsheet/checkpoint2/{trackingsheetID}")
	public String getCheckpoint2(@PathVariable int trackingsheetID,
			Model model){
		String title = "Checkpoint 2";
		TrackingSheet trackingsheet2 = new TrackingSheet();
		
		//This block get a tracking sheet to be updated
		if(trackingsheetID > 0){
			 // generate a new URI and append trackingsheetID to it
			String uri = defaultURI + "/" + trackingsheetID;
			
			// Get a checkpoint2 from web servive
			RestTemplate restTrackingSheet = new RestTemplate();
			trackingsheet2 = restTrackingSheet.getForObject(uri,
					TrackingSheet.class);

			//Give a new title to the page
			title = "Edit Checkpoint2";
		}
		
		/**
		 * The URI to get checkpoint unit
		 * List all checkpoint unit for drop down list menu
		 */
		RestTemplate checkpoint2REST = new RestTemplate();
		ResponseEntity<Checkpoint[]> responseCheckpoint2 = 
				checkpoint2REST.getForEntity("http://localhost:8080/arriving"
						+ "/api/checkpoints", Checkpoint[].class);
		
		// Parse a JSON data to array of object
		Checkpoint checkpointArray[] = responseCheckpoint2.getBody();
		
		// Parse an array to a list object
		List<Checkpoint> checkpointList = Arrays.asList(checkpointArray);
		
		/**
		 * The uri for get conveyer lane
		 * List of all conveyer lane for drop down menu
		 */
		RestTemplate restTemplateConveyorlane = new RestTemplate();
		ResponseEntity<ConveyorLane[]> responseConveyorlane =
				restTemplateConveyorlane.getForEntity("http://localhost:"
						+ "8080/arriving/api/conveyorlanes",
						ConveyorLane[].class );
		
		ConveyorLane conveyorlaneArray[] = responseConveyorlane.getBody();
		
		//Parse an array to a list object
		List<ConveyorLane> conveyorlaneList = Arrays.asList(conveyorlaneArray);
	
		/**
		 * The uri to get luggage unit
		 * List all luggage in a drop down menu
		 */
		RestTemplate restTemplateluggage = new RestTemplate();
		ResponseEntity<Luggage[]> responseLuggage = 
				restTemplateluggage.getForEntity("http://localhost:8080"
						+ "/arriving/api/luggages", Luggage[].class);
		
		
		Luggage luggageArray[] = responseLuggage.getBody();
		
		//parse Array to a list obj
		List<Luggage> luggageList = Arrays.asList(luggageArray);
		
		// Attach values to the model
		model.addAttribute("trackingsheet2",trackingsheet2);
		model.addAttribute("checkpoints",checkpointList);
		model.addAttribute("conveyorlanes",conveyorlaneList);
		model.addAttribute("luggages",luggageList);
		model.addAttribute("pageTitle", title);
		         
		return "checkpoint2info";	
	}
	
	/**
	 * This method handles a POST request to save checkpoint 2 info of a sheet
	 * Sends a HTTP POST request to web service to save checkpoint 2
	 * 
	 * redirect to checkpoint3 input page
	 */
	@RequestMapping("/trackingsheet/checkpoint2/save")
	public String insertCheckpoint2(@ModelAttribute TrackingSheet trackingsheet)
	{
		String uri = defaultURI + "/checkpoint2/save";
		
		//create a new RestTemplate
		RestTemplate restTemplatecp2 = new RestTemplate();
		
		//Create a request body
		HttpEntity<TrackingSheet> request = 
				new HttpEntity<TrackingSheet>(trackingsheet);
		
		String trackingsheetCheckpoint2Response = "";
		
		if (trackingsheet.getTrackingsheetID()>0){
			//this block updates a new detail and send request as PUT
			restTemplatecp2.put(defaultURI, request, TrackingSheet.class);	
		}
		
		else{
			//This block as a new truck and send request as POST
			trackingsheetCheckpoint2Response = 
					restTemplatecp2.postForObject(uri, request, String.class);
		}
		
		System.out.println(trackingsheetCheckpoint2Response);
		
		// Rediriect to checkpoint
		return "redirect:/trackingsheet/checkpoint3/0";
	}
	
	/**
	 * Handles a GET request to retrieve information abt checkpoint 3 of a sheet
	 * Retrieves a staff, status and luggage unit information
	 * from web service. Add a retrieved data to model and pass
	 * it to checkpoint3 html view
	 * 
	 */
	@GetMapping("/trackingsheet/checkpoint3/{trackingsheetID}")
	public String getCheckpoint3 (@PathVariable int trackingsheetID,
			Model model){
		String title = "Checkpoint 3";
		TrackingSheet trackingsheet3 = new TrackingSheet();
		
		//This block get a tracking sheet to be updated
		if(trackingsheetID >0)
		{
			
			//Generate new URI and append trackingsheetID to it
			String uri = defaultURI + "/" + trackingsheetID;
			
			//Get a checkpoint 3 from web service
			RestTemplate restTracking = new RestTemplate();
			trackingsheet3 = restTracking.getForObject(uri, TrackingSheet.class);
			
			//Give a new title to page
			title = "Edit Checkpoint";
		}
		
		/**
		 * @author Auni Afeeqah
		 * the uri to get checkpoint 3 details
		 */
		
		RestTemplate checkpoint3REST = new RestTemplate();
		ResponseEntity<Checkpoint[]> responseCheckpoint3 =
				checkpoint3REST.getForEntity("http://localhost:8080/arriving"
						+ "/api/checkpoints", Checkpoint[].class);
				
				
		// Parse JSON data to array of object
		Checkpoint checkpointArray[] = responseCheckpoint3.getBody();
						
		// Parse an array to a list object
		List<Checkpoint> checkpointList = Arrays.asList(checkpointArray);
		
		
		/**
		 * the uri to get luggage unit
		 * list all luggage unit for drop down menu
		 */
		RestTemplate luggageREST = new RestTemplate();
		
		ResponseEntity<Luggage[]> responseLuggage=
				luggageREST.getForEntity("http://localhost:8080/arriving"
						+ "/api/luggages", Luggage[].class);
				
				
		// Parse JSON data to array of object
		Luggage luggageArray[] = responseLuggage.getBody();
						
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
	
		/**
		 * The uri to get staff
		 * List all of staff for drop down list menu
		 * 
		 */
		RestTemplate restTemplateStaff = new RestTemplate();
		ResponseEntity<Staff[]> responseStaff = 
				restTemplateStaff.getForEntity("http://localhost:"
						+ "8080/arriving/api/staffs", Staff[].class);
		
		Staff shuttlestaffArray[] = responseStaff.getBody();	
		
		// Parse an array to a list object
		List<Staff> staffList = Arrays.asList(shuttlestaffArray);
		
		//Attach value to pass the front end
		model.addAttribute("trackingsheet3", trackingsheet3);
		model.addAttribute("checkpoints", checkpointList);
		//model.addAttribute("luggagestatus", luggagestatusList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("staffs", staffList);
		model.addAttribute("pagetitle",title);
		
		return "checkpoint3info";
	}
	
	/**
	 * Handles a POST request to save checkpoint 3 information of a sheet.
	 * Sends an HTTP POST request to the web service to save the checkpoint 3 
	 * information.
	 * 
	 * Redirects to the tracking sheet
	 */
	
	@RequestMapping("/trackingsheet/checkpoint3/save")
	public String insertCheckpoint3 (@ModelAttribute TrackingSheet trackingsheet)
	{
		String uri = defaultURI + "/checkpoint3/save";
		
		// Create a new RestTemplate
		RestTemplate restTemplatecp3 = new RestTemplate();
		
		// Create request body
		HttpEntity<TrackingSheet> request = 
				new HttpEntity<TrackingSheet>(trackingsheet);
		
		String trackingsheetCheckpoint3Response = "";
		
		if (trackingsheet.getTrackingsheetID() > 0){
			// This block update an new order type and send request as PUT
			restTemplatecp3.put(defaultURI, request, TrackingSheet.class);
		}
		else {
			// This block ass a new passenger and send request as POST
			trackingsheetCheckpoint3Response = restTemplatecp3.postForObject(uri, 
					request, String.class);	
		}
		
		System.out.println(trackingsheetCheckpoint3Response);
		
		// Redirect to checkpoint 2 input
		//return "redirect:/trackingsheet/checkpoint4/0";
		return "redirect:/trackingsheet/list";
	}
	
	/**
	 * Handles a POST request to save checkpoint 4 information of a sheet.
	 * Sends an HTTP POST request to the web service to save the checkpoint 4 
	 * information.
	 * 
	 * This method will update the details of passenger claiming the luggage 
	 * or report their misssing luggage
	 * 
	 * Redirects to the "trackingsheet" input page.
	 */	
    @GetMapping("/trackingsheet/checkpoint4/list")
    public String getCp4detail(Model model)
	{
		// The URI for GET trackingsheet
		String uri = "http://localhost:8080/arriving/api/trackingsheets";
		
		//Get a list of passengers from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<TrackingSheet[]> response = 
				restTemplate.getForEntity(uri, TrackingSheet[].class);
		
		// Parse JSON data to array of object
		TrackingSheet trackingsheets[] = response.getBody();
		
		// Parse an array to a list object
		List<TrackingSheet> trackingsheetList = Arrays.asList(trackingsheets);
		
		//Attach list to model as attributes
		model.addAttribute("trackingsheets", trackingsheetList);
		
		return "checkpoint4";
	}
    
	/**
	 * Handles a POST request to save checkpoint 4 information of a sheet.
	 * Sends an HTTP POST request to the web service to save the checkpoint 4 
	 * information.
	 * 
	 * Redirects to the "trackingsheet" input page.
	 */
	@RequestMapping("/trackingsheet/checkpoint4/save")
	public String editCheckpoint4(@ModelAttribute TrackingSheet trackingsheet){
		String uri = defaultURI + "/checkpoint4/save";
		
		// Create a new RestTemplate
		RestTemplate restTemplatecp4 = new RestTemplate();
		
		// Create request body
		HttpEntity<TrackingSheet> request = 
				new HttpEntity<TrackingSheet>(trackingsheet);
		
		String trackingsheetCheckpoint4Response = "";
		
		if (trackingsheet.getTrackingsheetID() > 0){
			// This block update an new tracking sheet and send request as PUT
			restTemplatecp4.put(defaultURI, request, TrackingSheet.class);
		}
		else {
			// This block ass a new passenger and send request as POST
			trackingsheetCheckpoint4Response = 
					restTemplatecp4.postForObject(uri,
					request, String.class);
			
		}
		
		System.out.println(trackingsheetCheckpoint4Response);
		
		return "redirect:/trackingsheet/checkpoint4/list";
		//return "redirect:/trackingsheet/list";
	}
	
	/**
	 * This method gets a checkpoint4 info
	 * 
	 * @paramCheckPointId
	 * @param model
	 * @return
	 */
	@GetMapping("/trackingsheet/checkpoint4/{trackingsheetID}")
	public String getCheckpoint4 (@PathVariable int trackingsheetID, Model model)
	{
	
		String title = "Checkpoint 4";
		TrackingSheet trackingsheet4 = new TrackingSheet();

		// This block get an tracking list to be updated
		if (trackingsheetID > 0) {

			// Generate new URI and append trackingsheetID to it
			String uri = defaultURI + "/" + trackingsheetID;

			// Get an order type from the web service
			RestTemplate restTracking = new RestTemplate();
			trackingsheet4 = restTracking.getForObject(uri, TrackingSheet.class);

			//Give a new title to the page
			title = "Edit Checkpoint4";
		}
		
		
		/**
		 * The uri for get luggage unit
		 * List of all luggage unit for drop down list menu
		 */
		RestTemplate checkpoint4REST = new RestTemplate();
		ResponseEntity<Checkpoint[]> responseCheckpoint4 =
				checkpoint4REST.getForEntity("http://localhost:8080/arriving"
						+ "/api/checkpoints", Checkpoint[].class);
				
				
		// Parse JSON data to array of object
		Checkpoint checkpointArray[] = responseCheckpoint4.getBody();
						
		// Parse an array to a list object
		List<Checkpoint> checkpointList = Arrays.asList(checkpointArray);
	
		
		/**
		 * the uri to get luggage unit
		 * list all luggage unit for drop down menu
		 */
	
		RestTemplate luggageREST = new RestTemplate();
		
		ResponseEntity<Luggage[]> responseLuggage=
				luggageREST.getForEntity("http://localhost:8080/arriving"
						+ "/api/luggages", Luggage[].class);
				
				
		// Parse JSON data to array of object
		Luggage luggageArray[] = responseLuggage.getBody();
						
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);

		/**
		 * The uri to get staff
		 * List all of staff for drop down list menu
		 * 
		 */
		RestTemplate restTemplateStaff = new RestTemplate();
		ResponseEntity<Staff[]> responseStaff = 
				restTemplateStaff.getForEntity("http://localhost:"
						+ "8080/arriving/api/staffs", Staff[].class);
		
		Staff shuttlestaffArray[] = responseStaff.getBody();	
		
		// Parse an array to a list object
		List<Staff> staffList = Arrays.asList(shuttlestaffArray);
		
		//Attach value to pass the front end
		model.addAttribute("trackingsheet4", trackingsheet4);
		model.addAttribute("checkpoints", checkpointList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("staffs", staffList);
		model.addAttribute("pagetitle",title);
		
		System.out.println("tessttt");
		return "checkpoint4info";
	}

}