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
	private Passenger Passenger;
	
	@ManyToOne
	@JoinColumn(name = "FlightId")
	private Flight Flight;
	
	
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

	public Passenger getPassenger() {
		return Passenger;
	}

	public void setPassenger(Passenger passenger) {
		Passenger = passenger;
	}

	public Flight getFlight() {
		return Flight;
	}

	public void setFlight(Flight flight) {
		Flight = flight;
	}


}