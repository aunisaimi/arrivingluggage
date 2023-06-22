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

import arriving.luggage.flight.arrivingluggage.repository.Checkpoint2Repository;
import arriving.luggage.flight.arrivingluggage.model.Checkpoint2;

@RestController
@RequestMapping("/api/checkpoint2s")
public class Checkpoint2RESTController
{
	@Autowired
private Checkpoint2Repository checkpoint2Repository;
	
	@GetMapping
	public List<Checkpoint2> getCheckpoint2(){
		return checkpoint2Repository.findAll();
		
	}
	
//	
//	@GetMapping("{Checkpoint2Id}")
//	public Checkpoint2 getCheckpoint2(@PathVariable long Checkpoint2Id)
//	{
//		Checkpoint2 checkpoint2 = checkpoint2Repository.findById(Checkpoint2Id).get();
//		return checkpoint2;
//		
//	}
//	
//	@PostMapping()
//	public Checkpoint2 insertCheckpoint2 (@RequestBody Checkpoint2 checkpoint2)
//	{		
//		return checkpoint2Repository.save(checkpoint2);
//	}
//	
//	@PutMapping()
//	public Checkpoint2 updateCheckpoint2(@RequestBody Checkpoint2 checkpoint2)
//	{
//		return checkpoint2Repository.save(checkpoint2);
//	}
//	
//	@DeleteMapping("{Checkpoint2Id}")
//	public ResponseEntity<HttpStatus> deleteCheckpoint2(@PathVariable long Checkpoint2Id)
//	{
//		checkpoint2Repository.deleteById(Checkpoint2Id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
	
}
