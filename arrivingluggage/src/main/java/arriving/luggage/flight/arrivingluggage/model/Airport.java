package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the Airport model representing airport information.
 * 
 * @author Anis Sabrina
 *
 */
@Entity
@Table (name = "airport")
public class Airport {
	
    // Primary Key
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    // Column representing the airport id
	@Column (name = "AirportID")
	private int airportID;
	
    // Column representing the departure airport location 
	@Column (name = "DepartingAirport")
	private String departureLocation;
	
    // Column representing the arrival airport location 
	@Column (name = "ArrivalAirport")
	private String arrivalLocation;
	
	
	// Getter and Setter methods
	
	public int getAirportID() {
		return airportID;
	}

	public void setAirportID(int airportID) {
		this.airportID = airportID;
	}

	public String getDepartingAirport() {
		return departureLocation;
	}

	public void setDepartingAirport(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalAirport() {
		return arrivalLocation;
	}

	public void setArrivalAirport(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	
}
