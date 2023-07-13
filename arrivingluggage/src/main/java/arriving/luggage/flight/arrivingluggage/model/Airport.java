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
@Table (name = "airport")
public class Airport {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "AirportID")
	private int airportID;
	
	public int getAirportID() {
		return airportID;
	}

	public void setAirportID(int airportID) {
		this.airportID = airportID;
	}

	public String getDepartingAirport() {
		return departingAirport;
	}

	public void setDepartingAirport(String departingAirport) {
		this.departingAirport = departingAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	@Column (name = "DepartingAirport")
	private String departingAirport;
	
	@Column (name = "ArrivalAirport")
	private String arrivalAirport;



}
