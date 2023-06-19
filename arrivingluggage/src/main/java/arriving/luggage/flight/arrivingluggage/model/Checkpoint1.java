package arriving.luggage.flight.arrivingluggage.model;

import java.sql.Date;


import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name= "checkpoint1")
public class Checkpoint1
{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "Checkpoint1Id")
	private int Checkpoint1Id;
	
	@Column(name= "Checkpoint1Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Checkpoint1Date;
	
	@Column(name="Checkpoint1Time")
	private String Checkpoint1Time;
	
	//@ManyToOne
	@JoinColumn(name="TruckId")
	private Truck TruckId;
	
	//@ManyToOne
	@JoinColumn(name="LuggageId")
	private Luggage LuggageId;
	
	public int getCheckpoint1Id() {
		return Checkpoint1Id;
	
	}
	
	public Truck getTruckId() {
		return TruckId;
	}
	public void setTruckId(Truck truckId) {
		TruckId = truckId;
	}
	public Luggage getLuggageId() {
		return LuggageId;
	}
	public void setLuggageId(Luggage luggageId) {
		this.LuggageId = luggageId;
	}
	
	public void setCheckpoint1Id(int checkpoint1Id) {
		Checkpoint1Id = checkpoint1Id;
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
	
	
	
	
}
