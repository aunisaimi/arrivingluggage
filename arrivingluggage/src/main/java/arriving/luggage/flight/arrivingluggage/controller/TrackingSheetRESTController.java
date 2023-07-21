package arriving.luggage.flight.arrivingluggage.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import arriving.luggage.flight.arrivingluggage.repository.TrackingsheetRepository;
import arriving.luggage.flight.arrivingluggage.model.Checkpoint;
import arriving.luggage.flight.arrivingluggage.model.ConveyorLane;
import arriving.luggage.flight.arrivingluggage.model.Flight;
import arriving.luggage.flight.arrivingluggage.model.TrackingSheet;
import arriving.luggage.flight.arrivingluggage.model.Truck;
import arriving.luggage.flight.arrivingluggage.model.Luggage;

@RestController
@RequestMapping("/api/trackingsheets")
public class TrackingSheetRestController 
{
	@Autowired
	private TrackingsheetRepository trackingsheetRepository;
	
	@GetMapping
	public List<TrackingSheet> getTrackingSheet(){
		return trackingsheetRepository.findAll();
		
	}
	
	@GetMapping("{TrackingSheetId}")
	public TrackingSheet getTrackingSheet(@PathVariable long TrackingSheetId)
	{
		TrackingSheet trackingsheet = 
				trackingsheetRepository.findById(TrackingSheetId).get();
		return trackingsheet;
		
	}
	
	/*
	@PostMapping()
	public TrackingSheet insertTrackingSheet 
	(@RequestBody TrackingSheet trackingsheet)
	{		
		return trackingsheetRepository.save(trackingsheet);
	}
	*/
	
	@PutMapping()
	public TrackingSheet updateTrackingSheet
	(@RequestBody TrackingSheet trackingsheet)
	{
		return trackingsheetRepository.save(trackingsheet);
	}
	
	// Insert a sheet at checkpoint 4
		@PostMapping("checkpoint4/save")
		public TrackingSheet insertTrackingSheet(@RequestBody TrackingSheet
				trackingsheet) {
			
			LocalDateTime DateTime = LocalDateTime.now();
			trackingsheet.setDateTime(DateTime);
		    
		    // Set the ConveyorLane with ID 9999
		    ConveyorLane conveyorlane = new ConveyorLane();
		    conveyorlane.setConveyorLaneID(9999);
		    trackingsheet.setConveyorlane(conveyorlane);
		     
		    //Set the Truck with ID 9999
		    //Truck truck = new Truck();
		    //truck.setTruckID(9999);
		    //trackingsheet.setTruck(truck);
		   
		    // Set the Checkpoint with ID 9999
		    Checkpoint checkpoint = new Checkpoint();
		    checkpoint.setCheckpointID(4);
		    trackingsheet.setCheckpoint(checkpoint);
		    
		    // Set the Flight with ID 9999
		    Flight flight = new Flight();
		    flight.setFlightID(9999);
		    trackingsheet.setFlightID(flight);
		    
		    // Set the Luggage with ID 9999
		    Luggage luggage = new Luggage();
		    luggage.setLuggageID(9999);
		    trackingsheet.setLuggage(luggage);
		    
		    
			return trackingsheetRepository.save(trackingsheet);
		}
		
	
	@DeleteMapping("{TrackingSheetId}")
	public ResponseEntity<HttpStatus> deleteTrackingSheet(
			@PathVariable long TrackingSheetId)
	{
		trackingsheetRepository.deleteById(TrackingSheetId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}