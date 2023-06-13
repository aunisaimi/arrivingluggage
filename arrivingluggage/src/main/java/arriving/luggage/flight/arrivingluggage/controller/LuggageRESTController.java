package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import arriving.luggage.flight.arrivingluggage.repository.LuggageRepository;
import arriving.luggage.flight.arrivingluggage.model.Luggage;


@RestController
@RequestMapping("/api/luggages")
public class LuggageRESTController 
{
	@Autowired
	private LuggageRepository luggageRepository;
	@GetMapping
	public List<Luggage> getLuggage(){
		return luggageRepository.findAll();
		
	}
	
	
	@GetMapping("{LuggageId}")
	public Luggage getLuggage(@PathVariable long LuggageId)
	{
		Luggage luggage = luggageRepository.findById(LuggageId).get();
		return luggage;
		
	}
	
	@PostMapping()
	public Luggage insertLuggage (@RequestBody Luggage luggage)
	{		
		return luggageRepository.save(luggage);
	}
	
	@PutMapping()
	public Luggage updateLuggage(@RequestBody Luggage luggage)
	{
		return luggageRepository.save(luggage);
	}
	
	@DeleteMapping("{LuggageId}")
	public ResponseEntity<HttpStatus> deleteLuggage(@PathVariable long LuggageId)
	{
		luggageRepository.deleteById(LuggageId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
