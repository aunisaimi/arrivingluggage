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
import arriving.luggage.flight.arrivingluggage.model.ConveyorLane;


@RestController
@RequestMapping("/api/conveyorlanes")
public class ConveyorLaneController
{
	@Autowired
	private ConveyerlaneRepository conveyerlaneRepository;
	@GetMapping
	public List<ConveyorLane> getConveyerlane()
	{
		return conveyerlaneRepository.findAll();
	}
	
	@GetMapping("{conveyorLaneID}")
	public ConveyorLane getConveyerlane(@PathVariable long conveyorLaneID)
	{
		ConveyorLane conveyerlane = 
				conveyerlaneRepository.findById(conveyorLaneID).get();
		return conveyerlane;
	}
	
	@PostMapping()
	public ConveyorLane insertConveyerlane(@RequestBody ConveyorLane conveyerlane)
	{		
		return conveyerlaneRepository.save(conveyerlane);
	}
	
	@PutMapping()
	public ConveyorLane updateConveyerlane(@RequestBody ConveyorLane conveyerlane)
	{
		return conveyerlaneRepository.save(conveyerlane);
	}
	
	@DeleteMapping("{conveyorLaneID}")
	public ResponseEntity<HttpStatus> deleteConveyerlane
	(@PathVariable long conveyorLaneID)
	{
		conveyerlaneRepository.deleteById(conveyorLaneID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

