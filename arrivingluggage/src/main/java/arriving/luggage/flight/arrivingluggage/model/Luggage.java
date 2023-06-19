package arriving.luggage.flight.arrivingluggage.model;


//import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "luggage")
public class Luggage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "LuggageId")
	private int LuggageId;
	
	@Column (name = "LuggageStatus")
	private String LuggageStatus;
	
	
	
	
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


	





	

	
}

