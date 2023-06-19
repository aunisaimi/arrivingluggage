package arriving.luggage.flight.arrivingluggage.model;
import jakarta.persistence.GenerationType;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name= "checkpoint2")
public class Checkpoint2 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "CheckPoint2Id")
	private int CheckPoint2Id;
	
	//@ManyToOne
	@JoinColumn(name="ConveyerLaneId")
	private int ConveyerLaneId;
	
	//@ManyToOne
	@JoinColumn (name ="LuggageId")
	private int LuggageId;
	
	@Column(name= "Checkpoint2Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Checkpoint2Date;
	
	@Column(name="Checkpoint2Time")
	private String Checkpoint2Time;

	
	public Checkpoint2() {
		
	}
	
	public Checkpoint2(int checkpoint2id) {
		this.CheckPoint2Id = checkpoint2id;
	}
	
	public int getCheckPoint2Id() {
		return CheckPoint2Id;
	}

	public void setCheckpoint2Id(int checkpoint2Id) {
		CheckPoint2Id = checkpoint2Id;
	}

	public int getConveyerLaneId() {
		return ConveyerLaneId;
	}

	public void setConveyerLaneId(int conveyerLaneId) {
		ConveyerLaneId = conveyerLaneId;
	}

//	public Luggage getLuggageId() {
//		return LuggageId;
//	}
//
//	public void setLuggageId(Luggage luggageId) {
//		LuggageId = luggageId;
//	}

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
	
	
	
	
	

}
