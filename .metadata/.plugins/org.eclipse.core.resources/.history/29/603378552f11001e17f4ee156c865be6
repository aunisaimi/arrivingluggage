package arriving.luggage.flight.arrivingluggage.model;

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
public class Luggage 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "LuggageId")
	private int LuggageId;
	
	@ManyToOne
	@JoinColumn(name = "PassengerId")
	private Passenger PassengerId;
	
	@ManyToOne
	@JoinColumn(name = "FlightId")
	private Flight FlightId;
	
	
	public Luggage() {
        // Default constructor logic
    }

	public Luggage(int luggageid) {
        this.LuggageId = luggageid;
    }
    
	public int getLuggageId() {
		return LuggageId;
	}

	public void setLuggageId(int luggageId) {
		LuggageId = luggageId;
	}

	public Passenger getPassengerId() {
		return PassengerId;
	}

	public void setPassengerId(Passenger passengerId) {
		PassengerId = passengerId;
	}
	
    public Flight getFlightId() {
		return FlightId;
	}

	public void setFlightId(Flight flightId) {
		FlightId = flightId;
	}	
}
