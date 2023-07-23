package arriving.luggage.flight.arrivingluggage.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * 
 * @author Anis Sabrina
 *
 */

@Entity
@Table(name = "luggage")
public class Luggage 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "LuggageID")
	private int luggageID;
		 
	@ManyToOne
	@JoinColumn (name = "passengerID")
	private Passenger passengerID; 	
	
	/*@OneToMany(mappedBy = "luggage",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("luggage")
	private List<TrackingSheet> trackingsheets;*/


	public int getLuggageID() {
		return luggageID;
	}

	public void setLuggageID(int luggageID) {
		this.luggageID = luggageID;
	}

	public Passenger getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(Passenger passengerID) {
		this.passengerID = passengerID;
	}
	


}