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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="TruckId")
	private int TruckId;
	
	@Column (name="TruckRegistrationNo")
	private String TruckRegistrationNo;
	
	
	
	public int getTruckId() {
		return TruckId;
	}
	public void setTruckId(int truckId) {
		TruckId = truckId;
	}
	public String getTruckRegistrationNo() {
		return TruckRegistrationNo;
	}
	public void setTruckRegistrationNo(String truckRegistrationNo) {
		TruckRegistrationNo = truckRegistrationNo;
	}
	
	
}
