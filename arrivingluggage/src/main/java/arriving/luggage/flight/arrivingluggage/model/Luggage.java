package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	
}
