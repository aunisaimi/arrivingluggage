package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import arriving.luggage.flight.arrivingluggage.model.Checkpoint;
import arriving.luggage.flight.arrivingluggage.repository.CheckpointRepository;


@RestController
@RequestMapping("/api/checkpoint1s")
public class Checkpointrestcontroller 
{
	@Autowired
	private CheckpointRepository checkpointRepository;
	
	@GetMapping
	public List<Checkpoint> getCheckpoint1()
	{
		return checkpointRepository.findAll();
	}
	
	@GetMapping ("{checkpointID}")
	public Checkpoint getCheckpoint1(@PathVariable long checkpointID)
	{
		Checkpoint checkpoint = 
				checkpointRepository.findById(checkpointID).get();
		
		return checkpoint;
	}
}
