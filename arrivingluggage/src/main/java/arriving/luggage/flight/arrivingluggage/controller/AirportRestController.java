package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arriving.luggage.flight.arrivingluggage.model.Airport;
import arriving.luggage.flight.arrivingluggage.repository.AirportRepository;


@RestController
@RequestMapping("/api/airports")
public class AirportRestController 
{
	@Autowired
	private AirportRepository airportRepository;
	@GetMapping
	public List<Airport> getAirport(){
		return airportRepository.findAll();
		
	}
	
	
	@GetMapping("{airportID}")
	public Airport getAirport(@PathVariable long airportID)
	{
		Airport airport = airportRepository.findById(airportID).get();
		return airport;
		
	}	
}
