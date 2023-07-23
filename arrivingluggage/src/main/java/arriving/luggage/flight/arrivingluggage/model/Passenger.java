package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This class is the passenger model representing passenger information.
 * 
 * This class is mapped to a database table named 
 * "passenger" using JPA annotations.
 * It represents information about a passenger, including 
 * their unique ID, name, phone number, email, gender, and passport/ID.
 * It also includes a foreign key reference to the associated flight.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "passenger"
@Entity
@Table(name = "passenger") 
public class Passenger {
    
    // Primary Key
    @Id
    // Specifies that the passengerID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the passenger id
    @Column(name = "PassengerID")
    private int passengerID;
    
    // Column representing the passenger's name
    @Column(name = "Name")
    private String name;
    
    // Column representing the passenger's phone number
    @Column(name = "PhoneNumber")
    private String phoneNo;
    
    // Column representing the passenger's email
    @Column(name = "Email")
    private String email;
    
    // Column representing the passenger's gender
    @Column(name = "Gender")
    private String gender;
    
    // Column representing the passenger's IC/ passport
    @Column(name = "PassengerIC/Passport")
    private String passengerIC;
    
    // Column representing the flight ID as a foreign key
    @ManyToOne
    @JoinColumn(name = "FlightID")
    private Flight flightID;

    // Getter and Setter methods

    // Get the passenger ID
    public int getPassengerID() {
        return passengerID;
    }

    // Set the passenger ID
    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    // Get the passenger's name
    public String getName() {
        return name;
    }

    // Set the passenger's name
    public void setName(String name) {
        this.name = name;
    }

    // Get the passenger's phone number
    public String getPhoneNo() {
        return phoneNo;
    }

    // Set the passenger's phone number
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    // Get the passenger's email
    public String getEmail() {
        return email;
    }

    // Set the passenger's email
    public void setEmail(String email) {
        this.email = email;
    }

    // Get the passenger's gender
    public String getGender() {
        return gender;
    }

    // Set the passenger's gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Get the passenger's IC/ passport
    public String getPassengerIC() {
        return passengerIC;
    }

    // Set the passenger's IC/ passport
    public void setPassengerIC(String passengerIC) {
        this.passengerIC = passengerIC;
    }

    // Get the associated flight
    public Flight getFlightID() {
        return flightID;
    }

    // Set the associated flight
    public void setFlightID(Flight flightID) {
        this.flightID = flightID;
    }
    
}
