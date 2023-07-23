package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * This class is the luggage model representing luggage information.
 * 
 * This class is mapped to a database table named 
 * "luggage" using JPA annotations.
 * It represents information about a piece of luggage, 
 * including its unique ID and the associated passenger.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "luggage"
@Entity
@Table(name = "luggage") 
public class Luggage {
    
    // Primary Key
    @Id
    // Specifies that the luggageID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the luggage id
    @Column(name = "LuggageID")
    private int luggageID;
    
    // Column representing the passenger id as a foreign key
    @ManyToOne
    @JoinColumn(name = "passengerID")
    private Passenger passengerID;

    // Getter and Setter methods

    // Get the luggage ID
    public int getLuggageID() {
        return luggageID;
    }

    // Set the luggage ID
    public void setLuggageID(int luggageID) {
        this.luggageID = luggageID;
    }

    // Get the associated passenger
    public Passenger getPassengerID() {
        return passengerID;
    }

    // Set the associated passenger
    public void setPassengerID(Passenger passengerID) {
        this.passengerID = passengerID;
    }
    
}
