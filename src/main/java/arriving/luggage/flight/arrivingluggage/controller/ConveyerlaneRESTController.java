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

import arriving.luggage.flight.arrivingluggage.repository.ConveyerlaneRepository;
import arriving.luggage.flight.arrivingluggage.model.Conveyerlane;


@RestController
@RequestMapping("/api/conveyerlanes")
public class ConveyerlaneRESTController
{
	@Autowired
	private ConveyerlaneRepository conveyerlaneRepository;
	@GetMapping
	public List<Conveyerlane> getConveyerlane()
	{
		return conveyerlaneRepository.findAll();
	}
	
	@GetMapping("{ConveyerLaneId}")
	public Conveyerlane getConveyerlane(@PathVariable long ConveyerLaneId)
	{
		Conveyerlane conveyerlane = conveyerlaneRepository.findById(ConveyerLaneId).get();
		return conveyerlane;
	}
	
	@PostMapping()
	public Conveyerlane insertConveyerlane(@RequestBody Conveyerlane conveyerlane)
	{		
		return conveyerlaneRepository.save(conveyerlane);
	}
	
	@PutMapping()
	public Conveyerlane updateConveyerlane(@RequestBody Conveyerlane conveyerlane)
	{
		return conveyerlaneRepository.save(conveyerlane);
	}
	
	@DeleteMapping("{ConveyerLaneId}")
	public ResponseEntity<HttpStatus> deleteConveyerlane(@PathVariable long ConveyerLaneId)
	{
		conveyerlaneRepository.deleteById(ConveyerLaneId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

