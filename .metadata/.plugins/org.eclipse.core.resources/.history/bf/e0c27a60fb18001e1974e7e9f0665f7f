package arriving.luggage.flight.arrivingluggage.model;


import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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


@Entity
@Table(name = "trackingsheet")
public class TrackingSheet
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "TrackingSheetId")
	private int TrackingSheetId;
	
	@ManyToOne
	@JoinColumn(name="FlightId")
	private Flight Flight;
	
	@ManyToOne
	@JoinColumn(name="LuggageId")
	private Luggage Luggage;
	
	@Column(name="Checkpoint1Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Checkpoint1Date;
	
	@Column(name="Checkpoint1Time")
	private String Checkpoint1Time;
	
	@Column(name="Checkpoint2Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Checkpoint2Date;
	
	@Column(name="Checkpoint2Time")
	private String Checkpoint2Time;
	
	@Column(name="Checkpoint3Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Checkpoint3Date;
	
	@Column(name="Checkpoint3Time")
	private String Checkpoint3Time;

	

	public TrackingSheet()
	{
		//DEfault constructor logic
	}
	public int getTrackingSheetId() {
		return TrackingSheetId;
	}

	public void setTrackingSheetId(int trackingSheetId) {
		TrackingSheetId = trackingSheetId;
	}

	
	public Flight getFlight() {
		return Flight;
	}
	public void setFlight(Flight flight) {
		Flight = flight;
	}
	public Luggage getLuggage() {
		return Luggage;
	}
	public void setLuggage(Luggage luggage) {
		Luggage = luggage;
	}
	public Date getCheckpoint1Date() {
		return Checkpoint1Date;
	}

	public void setCheckpoint1Date(Date checkpoint1Date) {
		Checkpoint1Date = checkpoint1Date;
	}

	public String getCheckpoint1Time() {
		return Checkpoint1Time;
	}

	public void setCheckpoint1Time(String checkpoint1Time) {
		Checkpoint1Time = checkpoint1Time;
	}

	public Date getCheckpoint2Date() {
		return Checkpoint2Date;
	}

	public void setCheckpoint2Date(Date checkpoint2Date) {
		Checkpoint2Date = checkpoint2Date;
	}

	public String getCheckpoint2Time() {
		return Checkpoint2Time;
	}

	public void setCheckpoint2Time(String checkpoint2Time) {
		Checkpoint2Time = checkpoint2Time;
	}

	public Date getCheckpoint3Date() {
		return Checkpoint3Date;
	}

	public void setCheckpoint3Date(Date checkpoint3Date) {
		Checkpoint3Date = checkpoint3Date;
	}

	public String getCheckpoint3Time() {
		return Checkpoint3Time;
	}

	public void setCheckpoint3Time(String checkpoint3Time) {
		Checkpoint3Time = checkpoint3Time;
	}
	
	
	
}
