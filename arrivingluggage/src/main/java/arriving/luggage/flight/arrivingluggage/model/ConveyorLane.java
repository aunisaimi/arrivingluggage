package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the ConveyorLane model representing
 * conveyor lane information.
 * @author Anis Sabrina
 *
 */
@Entity
@Table(name= "conveyorlane")
public class ConveyorLane {
	
	// Primary Key
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	// Column representing the conveyor lane ID
	@Column (name = "ConveyorLaneID")
	private int conveyorLaneID;
	
	// Column representing the lane station
	@Column (name = "LaneNumber")
	private String laneStation;
	
	
    // Getter and Setter methods
	
	public int getConveyorLaneID() {
		return conveyorLaneID;
	}

	public void setConveyorLaneID(int conveyorLaneID) {
		this.conveyorLaneID = conveyorLaneID;
	}

	public String getLaneNumber() {
		return laneStation;
	}

	public void setLaneNumber(String laneStation) {
		this.laneStation = laneStation;
	}
	
}

