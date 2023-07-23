package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the conveyorLane model representing conveyor lane information.
 * 
 * This class is mapped to a database table named 
 * "conveyorlane" using JPA annotations.
 * It represents information about a conveyor lane, 
 * including its unique ID and lane station.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "conveyorlane"
@Entity
@Table(name = "conveyorlane") 
public class ConveyorLane {
    
    // Primary Key
    @Id
    // Specifies that the conveyorLaneID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the conveyor lane ID
    @Column(name = "ConveyorLaneID")
    private int conveyorLaneID;
    
    // Column representing the lane station
    @Column(name = "LaneNumber")
    private String laneStation;

    // Getter and Setter methods

    // Get the conveyor lane ID
    public int getConveyorLaneID() {
        return conveyorLaneID;
    }

    // Set the conveyor lane ID
    public void setConveyorLaneID(int conveyorLaneID) {
        this.conveyorLaneID = conveyorLaneID;
    }

    // Get the lane station
    public String getLaneNumber() {
        return laneStation;
    }

    // Set the lane station
    public void setLaneNumber(String laneStation) {
        this.laneStation = laneStation;
    }
    
}
