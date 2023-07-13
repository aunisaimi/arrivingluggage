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
	private int LuggagE;
		 
	@ManyToOne
	@JoinColumn (name = "passengerID")
	private Passenger passenger; 	
	
	/*@OneToMany(mappedBy = "luggage",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("luggage")
	private List<TrackingSheet> trackingsheets;*/


	public int getLuggagE() {
		return LuggagE;
	}

	public void setLuggagE(int luggagE) {
		LuggagE = luggagE;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	/*public List<TrackingSheet> getTrackingsheets() {
		return trackingsheets;
	}

	public void setTrackingsheets(List<TrackingSheet> trackingsheets) {
		this.trackingsheets = trackingsheets;
	}

	*/
}