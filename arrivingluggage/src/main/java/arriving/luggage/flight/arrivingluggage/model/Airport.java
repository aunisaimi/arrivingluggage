package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the airport model representing airport information.
 * 
 * This class is mapped to a database table
 * named "airport" using JPA annotations.
 * It represents information about an airport, 
 * including its unique ID, departure location, and arrival location.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "airport"
@Entity
@Table(name = "airport") 
public class Airport {
    
    // Primary Key
    @Id
    // Specifies that the airportID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the airport id
    @Column(name = "AirportID")
    private int airportID;
    
    // Column representing the departure airport location
    @Column(name = "DepartingAirport")
    private String departureLocation;
    
    // Column representing the arrival airport location
    @Column(name = "ArrivalAirport")
    private String arrivalLocation;
    
    
    // Getter and Setter methods

    // Get the airport ID
    public int getAirportID() {
        return airportID;
    }

    // Set the airport ID
    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    // Get the departure airport location
    public String getDepartingAirport() {
        return departureLocation;
    }

    // Set the departure airport location
    public void setDepartingAirport(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    // Get the arrival airport location
    public String getArrivalAirport() {
        return arrivalLocation;
    }

    // Set the arrival airport location
    public void setArrivalAirport(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }
    
}
