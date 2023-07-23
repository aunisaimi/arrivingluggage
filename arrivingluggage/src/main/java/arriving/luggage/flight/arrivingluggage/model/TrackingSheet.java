package arriving.luggage.flight.arrivingluggage.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This class is the tracking sheet model representing 
 * tracking sheet information.
 * 
 * This class is mapped to a database table named 
 * "trackingsheet" using JPA annotations.
 * It represents information about a tracking sheet, 
 * including its unique ID, associated luggage, staff, checkpoint, truck,
 * conveyor lane, flight, status, and date and time.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "trackingsheet"
@Entity
@Table(name = "trackingsheet") 
public class TrackingSheet {
    
    // Primary Key
    @Id
    // Specifies that the trackingsheetID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the tracking sheet id
    @Column(name = "TrackingsheetID")
    private int trackingsheetID;
    
    // Indicate properties of the trackingsheet 
    //class to be ignored when serializing to JSON
    @JsonIgnoreProperties("trackingsheet")
    // Column representing the luggage id as a foreign key
    @ManyToOne
    @JoinColumn(name = "LuggageID")
    private Luggage luggage;
    
    // Column representing the staff id as a foreign key
    @ManyToOne
    @JoinColumn(name = "StaffID")
    private Staff staffID;
    
    // Column representing the checkpoint id as a foreign key
    @ManyToOne
    @JoinColumn(name = "CpID")
    private Checkpoint checkpoint;
    
    // Column representing the truck id as a foreign key
    @ManyToOne
    @JoinColumn(name = "TruckID")
    private Truck truck;
    
    // Column representing the conveyorlane id as a foreign key
    @ManyToOne
    @JoinColumn(name = "ConveyorLaneID")
    private ConveyorLane conveyorlane;
    
    // Column representing the flight id as a foreign key
    @ManyToOne
    @JoinColumn(name = "FlightID")
    private Flight flightID;
    
    // Column representing the luggage status
    @Column(name = "Status")
    private String status;
    
    // Column representing the date and time for every checkpoint
    @Column(name = "DateTime")
    private LocalDateTime dateTime;

    // Getter and Setter methods

    // Get the tracking sheet ID
    public int getTrackingsheetID() {
        return trackingsheetID;
    }

    // Set the tracking sheet ID
    public void setTrackingsheetID(int trackingsheetID) {
        this.trackingsheetID = trackingsheetID;
    }

    // Get the associated luggage
    public Luggage getLuggage() {
        return luggage;
    }

    // Set the associated luggage
    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    // Get the associated staff
    public Staff getStaffID() {
        return staffID;
    }

    // Set the associated staff
    public void setStaffID(Staff staffID) {
        this.staffID = staffID;
    }

    // Get the associated checkpoint
    public Checkpoint getCheckpoint() {
        return checkpoint;
    }

    // Set the associated checkpoint
    public void setCheckpoint(Checkpoint checkpoint) {
        this.checkpoint = checkpoint;
    }

    // Get the associated truck
    public Truck getTruck() {
        return truck;
    }

    // Set the associated truck
    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    // Get the associated conveyorlane
    public ConveyorLane getConveyorlane() {
        return conveyorlane;
    }

    // Set the associated conveyorlane
    public void setConveyorlane(ConveyorLane conveyorlane) {
        this.conveyorlane = conveyorlane;
    }

    // Get the associated flight
    public Flight getFlightID() {
        return flightID;
    }

    // Set the associated flight
    public void setFlightID(Flight flightID) {
        this.flightID = flightID;
    }

    // Get the luggage status
    public String getStatus() {
        return status;
    }

    // Set the luggage status
    public void setStatus(String status) {
        this.status = status;
    }

    // Get the date and time for every checkpoint
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Set the date and time for every checkpoint
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
}
