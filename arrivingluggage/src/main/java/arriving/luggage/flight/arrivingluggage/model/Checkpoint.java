package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the Checkpoint model representing checkpoint information.
 * 
 * @author Anis Sabrina
 *
 */
@Entity
@Table (name = "checkpoint")
public class Checkpoint {
	
	// Primary Key
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	// Column representing the checkpoint id
	@Column (name = "cpID")
	private int checkpointID;
	
	// Column representing the checkpoint name
	@Column (name = "CheckpointName")
	private String name;

	
	// Getter and Setter methods
	
	public int getCheckpointID() {
		return checkpointID;
	}

	public void setCheckpointID(int checkpointID) {
		this.checkpointID = checkpointID;
	}

	public String getCheckpointName() {
		return name;
	}

	public void setCheckpointName(String name) {
		this.name = name;
	}
	
}
