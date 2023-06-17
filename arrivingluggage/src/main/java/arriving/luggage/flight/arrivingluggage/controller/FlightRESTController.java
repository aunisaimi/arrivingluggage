package arriving.luggage.flight.arrivingluggage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arriving.luggage.flight.arrivingluggage.model.Flight;
import arriving.luggage.flight.arrivingluggage.repository.FlightRepository;

@RestController
@RequestMapping ("/api/flights")
public class FlightRESTController 
{
	@Autowired
	private FlightRepository flightRepository;
	@GetMapping
	public List<Flight> getFlight(){
		return flightRepository.findAll();
		
	}
	
	
	@GetMapping("{FlightId}")
	public Flight getFlight(@PathVariable long FlightId)
	{
		Flight flight = flightRepository.findById(FlightId).get();
		return flight;
		
	}
	
	@PostMapping()
	public Flight insertFlight (@RequestBody Flight flight)
	{		
		return flightRepository.save(flight);
	}
	
	@PutMapping()
	public Flight updateFlight(@RequestBody Flight flight)
	{
		return flightRepository.save(flight);
	}
	
	@DeleteMapping("{FlightId}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable long FlightId)
	{
		flightRepository.deleteById(FlightId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
