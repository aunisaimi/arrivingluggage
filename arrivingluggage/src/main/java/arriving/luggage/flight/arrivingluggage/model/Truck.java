package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Truck")
public class Truck 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "TruckID")
	private int Truck;
	


	public int getTruck() {
		return Truck;
	}

	public void setTruck(int truck) {
		Truck = truck;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column (name = "OperatorName")
	private String operatorName;
	
	@Column (name = "Location")
	private String location;
	
	
	
	
}
