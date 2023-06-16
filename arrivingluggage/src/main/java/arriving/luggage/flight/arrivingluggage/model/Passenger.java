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
	private int passengerId;
	
	@Column (name = "PassengerName")
	private String passengerName;
	
	@Column (name = "PassengerIC")
	private int passengerIC;
	
	
	/*
	@ManyToOne
	@JoinColumn(name = "Flight")
	private Flight flight;
	*/
	
	public int getPassengerId() {
		return passengerId;
	}
	
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	
	public String getPassengerName() {
		return passengerName;
	}
	
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public int getPassengerIC() {
		return passengerIC;
	}
	
	public void setPassengerIC(int passengerIC) {
		this.passengerIC = passengerIC;
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

