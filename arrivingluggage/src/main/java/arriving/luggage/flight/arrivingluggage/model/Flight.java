package arriving.luggage.flight.arrivingluggage.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This class is the Flight model representing
 * flight information.
 * 
 * @author Anis Sabrina
 *
 */

@Entity
@Table (name = "flight")
public class Flight {
	
	// Column representing the flight id
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	// Column representing the flight id
	@Column (name = "FlightID")
	private int flightID;
	
	// Column representing the airlines
	@Column (name = "FlightName")
	private String airlines;
	
	@Column (name = "DepartingTime")
	private Time departureTime;
	
	@Column (name = "ArrivingTime")
	private Time arrivalTime;
	
	@Column (name = "DepartingDate")
	private Date departureDate;
	
	@Column (name = "ArrivingDate")
	private Time arrivalDate;
	
	// Column representing the flight number
	@Column (name = "FlightNo")
	private String flightNumber;
	
	@ManyToOne
	@JoinColumn (name = "AirportID")
	private Airport airport;
	
	public Flight() {
		//default constructor
	}
	
	public Flight(int flightID) {
	    this.flightID = flightID;
	}
	
	public int getFlightID() {
		return flightID;
	}

	public String getFlightName() {
		return airlines;
	}

	public void setFlightName(String airlines) {
		this.airlines = airlines;
	}

	public Time getDepartingTime() {
		return departureTime;
	}

	public void setDepartingTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivingTime() {
		return arrivalTime;
	}

	public void setArrivingTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartingDate() {
		return departureDate;
	}

	public void setDepartingDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Time getArrivingDate() {
		return arrivalDate;
	}

	public void setArrivingDate(Time arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getFlightNo() {
		return flightNumber;
	}

	public void setFlightNo(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

}

