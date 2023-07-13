package arriving.luggage.flight.arrivingluggage.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
	@ManyToOne
	@JoinColumn(name="TruckId")
	private Truck Truck;
	
	@OneToOne
	@JoinColumn(name="LuggageId")
	private Luggage Luggage;
	
	@Column(name= "Checkpoint1Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Checkpoint1Date;
	
	@Column(name="Checkpoint1Time")
	private String Checkpoint1Time;
	
	
	public Checkpoint1() {
        // Default constructor logic
    }

    public Checkpoint1(int checkpoint1Id) {
        this.Checkpoint1Id = checkpoint1Id;
    }

	public int getCheckpoint1Id() {
		return Checkpoint1Id;
	}

	public void setCheckpoint1Id(int checkpoint1Id) {
		Checkpoint1Id = checkpoint1Id;
	}


	public Truck getTruck() {
		return Truck;
	}

	public void setTruck(Truck truck) {
		Truck = truck;
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
}