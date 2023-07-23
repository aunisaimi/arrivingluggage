package arriving.luggage.flight.arrivingluggage.controller;

import java.util.ArrayList;
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
public class LuggageRestController 
{
	@Autowired
	private LuggageRepository luggageRepository;
	
	@GetMapping
	public List<Luggage> getLuggage(){
		return luggageRepository.findAll();
    }
	
	@GetMapping("{luggageID}")
	public Luggage getLuggage(@PathVariable long luggageID)
	{
		Luggage luggage = luggageRepository.findById(luggageID).get();
		return luggage;
		
	}
	
}
