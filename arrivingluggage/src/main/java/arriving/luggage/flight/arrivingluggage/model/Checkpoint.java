package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import arriving.luggage.flight.arrivingluggage.model.Truck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.model.Luggage;
import arriving.luggage.flight.arrivingluggage.repository.LuggageRepository;

@Entity
@Table (name = "checkpoint")
public class Checkpoint 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cpID")
	private int checkpointID;
	
	@Column (name = "CheckpointName")
	private String CheckpointName;


	public int getCheckpointID() {
		return checkpointID;
	}

	public void setCheckpointID(int checkpointID) {
		this.checkpointID = checkpointID;
	}

	public String getCheckpointName() 
	{
		return CheckpointName;
	}

	public void setCheckpointName(String checkpointName) {
		CheckpointName = checkpointName;
	}

	
	  
	
	
}
