package arriving.luggage.flight.arrivingluggage.model;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;




@Entity
@Table(name = "Luggage")

public class Luggage 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "LuggageId")
	private int LuggageId;
	
	@Column (name = "LuggageStatus")
	private String LuggageStatus;
	
	@ManyToOne
	@JoinColumn(name = "TruckId")
	private Truck TruckId;
	
	@Column(name= "DateC1")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateC1;
	
	@Column(name = "TimeC1")
	private String TimeC1;
	
	/*
	@ManyToOne
	@JoinColumn(name = "FlightId")
	private int FlightId;
	

	@Column(name= "DateC2")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateC2;
	
	@Column(name = "TimeC2")
	private String TimeC2;
	
	@Column(name= "DateC3")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateC3;
	
	@Column(name = "TimeC3")
	private String TimeC3;
	
	@Column(name= "DateC4")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateC4;
	
	@Column(name = "TimeC4")
	private String TimeC4;
	
	@ManyToOne
	@JoinColumn(name = "ConveyerLaneId")
	private int ConveyerLaneId;
	
	@ManyToOne
	@JoinColumn(name = "StaffId")
	private int StaffId;
	*/
	
	
	@ManyToOne
	@JoinColumn(name = "PassengerId")
	private Passenger PassengerId;
	
	
	
	public int getLuggageId() {
		return LuggageId;
	}
	
	
	public void setLuggageId(int luggageId) {
		LuggageId = luggageId;
	}
	
	
	public String getLuggageStatus() {
		return LuggageStatus;
	}
	
	
	public void setLuggageStatus(String luggageStatus) {
		LuggageStatus = luggageStatus;
	}


	public Passenger getPassengerId() {
		return PassengerId;
	}


	public void setPassengerId(Passenger passengerId) {
		PassengerId = passengerId;
	}
	

	public Truck getTruckId() {
		return TruckId;
	}


	public void setTruckId(Truck truckId) {
		TruckId = truckId;
	}

	

	public Date getDateC1() {
		return DateC1;
	}


	public void setDateC1(Date dateC1) {
		DateC1 = dateC1;
	}


	public String getTimeC1() {
		return TimeC1;
	}


	public void setTimeC1(String timeC1) {
		TimeC1 = timeC1;
	}



	
}


