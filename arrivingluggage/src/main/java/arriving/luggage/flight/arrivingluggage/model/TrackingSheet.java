package arriving.luggage.flight.arrivingluggage.model;


import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * 
 * @author Anis Sabrina
 *
 */

@Entity
@Table(name = "trackingsheet")
public class TrackingSheet
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "TrackingsheetID")
	private int trackingsheetID;
	
	@JsonIgnoreProperties("trackingsheet")
	@ManyToOne
	@JoinColumn (name = "LuggageID")
	private Luggage luggage;
	
	@ManyToOne
	@JoinColumn (name = "StaffID")
	private Staff staffID;
	
	@ManyToOne
	@JoinColumn (name = "CpID")
	private Checkpoint checkpoint;
	
	@ManyToOne
	@JoinColumn (name = "TruckID")
	private Truck truck;
	
	@ManyToOne
	@JoinColumn (name = "ConveyorLaneID")
	private ConveyorLane conveyorlane;
		
	@ManyToOne
	@JoinColumn (name = "FlightID")
	private Flight flightID;
	
	
	public Flight getFlightID() {
		return flightID;
	}

	public void setFlightID(Flight flightID) {
		this.flightID = flightID;
	}

	@Column (name = "DateTime")
	private LocalDateTime dateTime;

	public int getTrackingsheetID() {
		return trackingsheetID;
	}

	public void setTrackingsheetID(int trackingsheetID) {
		this.trackingsheetID = trackingsheetID;
	}

	public Luggage getLuggage() {
		return luggage;
	}

	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}



	public Staff getStaffID() {
		return staffID;
	}

	public void setStaffID(Staff staffID) {
		this.staffID = staffID;
	}

	public Checkpoint getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(Checkpoint checkpoint) {
		this.checkpoint = checkpoint;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public ConveyorLane getConveyorlane() {
		return conveyorlane;
	}

	public void setConveyorlane(ConveyorLane conveyorlane) {
		this.conveyorlane = conveyorlane;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	
}
