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

import arriving.luggage.flight.arrivingluggage.model.Checkpoint4;
import arriving.luggage.flight.arrivingluggage.repository.Checkpoint4Repository;

@RestController
@RequestMapping("/api/checkpoint4s")
public class Checkpoint4RESTController {

	@Autowired
	private Checkpoint4Repository checkpoint4Repository;
	
	@GetMapping
	public List<Checkpoint4> getCheckpoint4(){
		return checkpoint4Repository.findAll();
	}


	@GetMapping("{CheckPoint4Id}")
	public Checkpoint4 getCheckpoint4(@PathVariable long CheckPoint4Id)
	{
		Checkpoint4 checkpoint4 = checkpoint4Repository.findById(CheckPoint4Id).get();
		
		return checkpoint4;		
	}
		
	@PostMapping()
	public Checkpoint4 insertCheckpoint4 (@RequestBody Checkpoint4 checkpoint4)
	{		
		return checkpoint4Repository.save(checkpoint4);
	}
			
	@PutMapping()
	public Checkpoint4 updateCheckpoint4(@RequestBody Checkpoint4 checkpoint4)
	{
		return checkpoint4Repository.save(checkpoint4);
	}
			
	@DeleteMapping("{CheckPoint4Id}")
	public ResponseEntity<HttpStatus> deleteLuggage(@PathVariable long CheckPoint4Id) {
		checkpoint4Repository.deleteById(CheckPoint4Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}