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

import arriving.luggage.flight.arrivingluggage.model.Checkpoint3;
import arriving.luggage.flight.arrivingluggage.repository.Checkpoint3Repository;

@RestController
@RequestMapping("/api/checkpoint3s")
public class Checkpoint3RESTController {
	
	@Autowired
	private Checkpoint3Repository checkpoint3Repository;
	
	@GetMapping
	public List<Checkpoint3> getCheckpoint3(){
		return checkpoint3Repository.findAll();
	}


	@GetMapping("{CheckPoint3Id}")
	public Checkpoint3 getCheckpoint3(@PathVariable long CheckPoint3Id)
	{
		Checkpoint3 checkpoint3 = checkpoint3Repository.findById(CheckPoint3Id).get();
		
		return checkpoint3;		
	}
		
	@PostMapping()
	public Checkpoint3 insertCheckpoint3 (@RequestBody Checkpoint3 checkpoint3)
	{		
		return checkpoint3Repository.save(checkpoint3);
	}
			
	@PutMapping()
	public Checkpoint3 updateCheckpoint3(@RequestBody Checkpoint3 checkpoint3)
	{
		return checkpoint3Repository.save(checkpoint3);
	}
			
	@DeleteMapping("{CheckPoint3Id}")
	public ResponseEntity<HttpStatus> deleteLuggage(@PathVariable long CheckPoint3Id) {
		checkpoint3Repository.deleteById(CheckPoint3Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}