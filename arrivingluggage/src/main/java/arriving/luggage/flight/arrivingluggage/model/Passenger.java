package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "passenger")

public class Passenger
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "PassengerId")
	private int PassengerId;
	
	@Column (name = "PassengerName")
	private String PassengerName;
	
	@Column (name = "PassengerIc")
	private String PassengerIc;
	
	
	/*
	@ManyToOne
	@JoinColumn(name = "Flight")
	private Flight flight;
	*/
	
	public int getPassengerId() {
		return PassengerId;
	}
	
	public void setPassengerId(int passengerId) {
		PassengerId = passengerId;
	}
	
	public String getPassengerName() {
		return PassengerName;
	}
	
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}
	
	
	public String getPassengerIc() {
		return PassengerIc;
	}
	
	public void setPassengerIc(String passengerIc) {
		PassengerIc = passengerIc;
	}
	
	
	/*
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	*/
}
