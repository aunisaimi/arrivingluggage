package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the Truck model representing truck information.
 * 
 * This class is mapped to a database table named "Truck" using JPA annotations.
 * It represents information about a truck, including its unique ID, 
 * registration number, operator name, and location.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "Truck"
@Entity
@Table(name = "Truck") 
public class Truck {
    
    // Primary Key
    @Id
    // Specifies that the truckID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the truck id
    @Column(name = "TruckID")
    private int truckID;
    
    // Column representing the truck's registration number
    @Column(name = "RegistrationNo")
    private String registrationNo;
    
    // Column representing the truck's operator name
    @Column(name = "OperatorName")
    private String operatorName;
    
    // Column representing the truck's location
    @Column(name = "Location")
    private String location;

    // Getter and Setter methods

    // Get the truck ID
    public int getTruckID() {
        return truckID;
    }

    // Set the truck ID
    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    // Get the truck's operator name
    public String getOperatorName() {
        return operatorName;
    }

    // Set the truck's operator name
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    // Get the truck's location
    public String getLocation() {
        return location;
    }

    // Set the truck's location
    public void setLocation(String location) {
        this.location = location;
    }

    // Get the truck's registration number
    public String getRegistrationNo() {
        return registrationNo;
    }

    // Set the truck's registration number
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
    
}
