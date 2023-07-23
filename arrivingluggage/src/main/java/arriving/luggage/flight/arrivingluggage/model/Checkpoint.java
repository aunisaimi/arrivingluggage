package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the checkpoint model representing checkpoint information.
 * 
 * This class is mapped to a database table 
 * named "checkpoint" using JPA annotations.
 * It represents information about a checkpoint, 
 * including its unique ID and name.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "checkpoint"
@Entity
@Table(name = "checkpoint") 
public class Checkpoint {
	
    // Primary Key
    @Id
    // Specifies that the checkpointID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    
    // Column representing the checkpoint id
    @Column(name = "cpID")
    private int checkpointID;
    
    // Column representing the checkpoint name
    @Column(name = "CheckpointName")
    private String name;

    // Getter and Setter methods

    // Get the checkpoint ID
    public int getCheckpointID() {
        return checkpointID;
    }

    // Set the checkpoint ID
    public void setCheckpointID(int checkpointID) {
        this.checkpointID = checkpointID;
    }

    // Get the checkpoint name
    public String getCheckpointName() {
        return name;
    }

    // Set the checkpoint name
    public void setCheckpointName(String name) {
        this.name = name;
    }
    
}
