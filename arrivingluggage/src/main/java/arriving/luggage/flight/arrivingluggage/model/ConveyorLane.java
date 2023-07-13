package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author Anis Sabrina
 *
 */

@Entity
@Table(name= "conveyorlane")
public class ConveyorLane {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = "ConveyorLaneID")
	private int conveyorLaneID;
	
	@Column (name = "LaneNumber")
	private String laneNumber;
	

	
	public int getConveyorLaneID() {
		return conveyorLaneID;
	}

	public void setConveyorLaneID(int conveyorLaneID) {
		this.conveyorLaneID = conveyorLaneID;
	}

	public String getLaneNumber() {
		return laneNumber;
	}

	public void setLaneNumber(String laneNumber) {
		this.laneNumber = laneNumber;
	}

	
}
