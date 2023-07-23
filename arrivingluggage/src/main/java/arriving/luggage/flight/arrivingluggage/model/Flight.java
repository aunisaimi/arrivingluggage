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
 * This class is the flight model representing flight information.
 * 
 * This class is mapped to a database table named "flight" using JPA annotations.
 * It represents information about a flight, 
 * including its unique ID, airlines, departure and arrival times,
 * departure and arrival dates, flight number, and the associated airport.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "flight"
@Entity
@Table(name = "flight") 
public class Flight {
    
    // Column representing the flight id
    @Id
    // Specifies that the flightID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the flight id
    @Column(name = "FlightID")
    private int flightID;
    
    // Column representing the airlines
    @Column(name = "FlightName")
    private String airlines;
    
    // Column representing the flight departure time
    @Column(name = "DepartingTime")
    private Time departureTime;
    
    // Column representing the flight arrival time
    @Column(name = "ArrivingTime")
    private Time arrivalTime;
    
    // Column representing the flight departure date
    @Column(name = "DepartingDate")
    private Date departureDate;
    
    // Column representing the flight arrival date
    @Column(name = "ArrivingDate")
    private Date arrivalDate;
    
    // Column representing the flight number
    @Column(name = "FlightNo")
    private String flightNumber;
    
    // Column representing the airport id as a foreign key
    @ManyToOne
    @JoinColumn(name = "AirportID")
    private Airport airport;

    // Getter and Setter methods

    // Default constructor
    public Flight() {
    }

    // Constructor with flightID parameter
    public Flight(int flightID) {
        this.flightID = flightID;
    }

    // Get the flight ID
    public int getFlightID() {
        return flightID;
    }

    // Get the airlines
    public String getFlightName() {
        return airlines;
    }

    // Set the airlines
    public void setFlightName(String airlines) {
        this.airlines = airlines;
    }

    // Get the departure time
    public Time getDepartingTime() {
        return departureTime;
    }

    // Set the departure time
    public void setDepartingTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    // Get the arrival time
    public Time getArrivingTime() {
        return arrivalTime;
    }

    // Set the arrival time
    public void setArrivingTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    // Get the departure date
    public Date getDepartingDate() {
        return departureDate;
    }

    // Set the departure date
    public void setDepartingDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    // Get the arrival date
    public Date getArrivalDate() {
        return arrivalDate;
    }

    // Set the arrival date
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    // Get the flight number
    public String getFlightNo() {
        return flightNumber;
    }

    // Set the flight number
    public void setFlightNo(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    // Get the associated airport
    public Airport getAirport() {
        return airport;
    }

    // Set the associated airport
    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    // Set the flight ID
    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }
    
}
