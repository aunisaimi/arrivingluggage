package arriving.luggage.flight.arrivingluggage.model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name = "flight")
public class Flight
{
	//primary key here
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FlightId")
	private int FlightId;
	
	@Column(name="FlightName")
	private String FlightName;
	
	@Column(name = "ArrivalTime")
	private String ArrivalTime;
	
	
	public int getFlightId() {
		return FlightId;
	}
	

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public void setFlightId(int flightId) {
		FlightId = flightId;
	}
	
	public String getFlightName() {
		return FlightName;
	}
	
	public void setFlightName(String flightName) {
		FlightName = flightName;
	}
	
	
}

