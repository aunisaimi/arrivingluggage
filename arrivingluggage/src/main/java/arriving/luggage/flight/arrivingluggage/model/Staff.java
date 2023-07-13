package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name = "staff")
public class Staff
{
	
	//primary key here
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="staffID")
	private int staffID;
	
	@Column (name="staffName")
	private String name;
	
	@Column (name ="staffIC")
	private String staffIC;
	
	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStaffIC() {
		return staffIC;
	}

	public void setStaffIC(String staffIC) {
		this.staffIC = staffIC;
	}


	
}
