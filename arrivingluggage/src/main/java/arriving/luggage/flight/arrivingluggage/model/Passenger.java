package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import arriving.luggage.flight.arrivingluggage.model.Flight;

/**
 * 
 * @author Anis Sabrina
 *
 */


@Entity
@Table(name = "passenger")

public class Passenger
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "PassengerID")
	private int passengerID;
	
	public int getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassengerIC() {
		return passengerIC;
	}

	public void setPassengerIC(String passengerIC) {
		this.passengerIC = passengerIC;
	}

	public Flight getFlightID() {
		return flightID;
	}

	public void setFlightID(Flight flightID) {
		this.flightID = flightID;
	}

	@Column (name = "PassengerName")
	private String name;
	
	@Column (name = "PhoneNumber")
	private String phoneNo;
	
	@Column (name = "Email")
	private String email;
	
	@Column (name = "Gender")
	private String gender;
	
	@Column (name = "PassengerIC")
	private String passengerIC;
	
	@ManyToOne
	@JoinColumn (name = "FlightID")
	private Flight flightID;


	
}
