package arriving.luggage.flight.arrivingluggage.controller;

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
import arriving.luggage.flight.arrivingluggage.model.TrackingSheet;


@RestController
@RequestMapping("/api/trackingsheets")
public class TrackingSheetRESTController 
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
		TrackingSheet trackingsheet = trackingsheetRepository.findById(TrackingSheetId).get();
		return trackingsheet;
		
	}
	
	@PostMapping()
	public TrackingSheet insertTrackingSheet (@RequestBody TrackingSheet trackingsheet)
	{		
		return trackingsheetRepository.save(trackingsheet);
	}
	
	@PutMapping()
	public TrackingSheet updateTrackingSheet(@RequestBody TrackingSheet trackingsheet)
	{
		return trackingsheetRepository.save(trackingsheet);
	}
	
	@DeleteMapping("{TrackingSheetId}")
	public ResponseEntity<HttpStatus> deleteTrackingSheet(@PathVariable long TrackingSheetId)
	{
		trackingsheetRepository.deleteById(TrackingSheetId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}