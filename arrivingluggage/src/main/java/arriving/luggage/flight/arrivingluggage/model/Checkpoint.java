package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "checkpoint")
public class Checkpoint 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cpID")
	private int checkpointID;
	
	@Column (name = "CheckpointName")
	private String Name;


	public int getCheckpointID() {
		return checkpointID;
	}

	public void setCheckpointID(int checkpointID) {
		this.checkpointID = checkpointID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
}
