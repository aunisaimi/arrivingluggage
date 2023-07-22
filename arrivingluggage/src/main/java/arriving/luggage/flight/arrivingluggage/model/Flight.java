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
 * 
 * @author Anis Sabrina
 *
 */

@Entity
@Table (name = "flight")
public class Flight {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = "FlightID")
	private int flightID;
	
	@Column (name = "FlightName")
	private String flightName;
	
	@Column (name = "DepartingTime")
	private Time departingTime;
	
	@Column (name = "ArrivingTime")
	private Time arrivingTime;
	
	@Column (name = "DepartingDate")
	private Date departingDate;
	
	@Column (name = "ArrivingDate")
	private Time arrivingDate;
	
	@Column (name = "FlightNo")
	private String flightNo;
	
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

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Time getADpartingTime() {
		return departingTime;
	}

	public void setAepartingTime(Time departingTime) {
		this.departingTime = departingTime;
	}

	public Time getArrivingTime() {
		return arrivingTime;
	}

	public void setArrivingTime(Time arrivingTime) {
		this.arrivingTime = arrivingTime;
	}

	public Date getDepartingDate() {
		return departingDate;
	}

	public void setDepartingDate(Date departingDate) {
		this.departingDate = departingDate;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public Time getDepartingTime() {
		return departingTime;
	}

	public void setDepartingTime(Time departingTime) {
		this.departingTime = departingTime;
	}

	public Time getArrivingDate() {
		return arrivingDate;
	}

	public void setArrivingDate(Time arrivingDate) {
		this.arrivingDate = arrivingDate;
	}

	
}

