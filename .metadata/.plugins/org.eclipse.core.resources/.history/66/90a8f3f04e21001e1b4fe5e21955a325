package arriving.luggage.flight.arrivingluggage.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conveyerlane")
public class Conveyerlane
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "ConveyerLaneId")
	private int ConveyerLaneId;
	
	@Column (name="ConveyerLaneName")
	private String ConveyerLaneName;
	
	
	public int getConveyerLaneId() {
		return ConveyerLaneId;
	}
	public void setConveyerLaneId(int conveyerLaneId) {
		ConveyerLaneId = conveyerLaneId;
	}
	
	public String getConveyerLaneName() {
		return ConveyerLaneName;
	}
	
	public void setConveyerLaneName(String conveyerLaneName) {
		ConveyerLaneName = conveyerLaneName;
	}
	
	
}
