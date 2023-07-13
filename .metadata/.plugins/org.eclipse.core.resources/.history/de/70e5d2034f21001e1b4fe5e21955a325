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
	@Column(name="StaffId")
	private int StaffId;
	
	@Column (name="StaffName")
	private String StaffName;
	
	@Column (name ="StaffIc")
	private String StaffIc;
	
	
	public int getStaffId() {
		return StaffId;
	}
	public void setStaffId(int staffId) {
		this.StaffId = staffId;
	}
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		this.StaffName = staffName;
	}
	public String getStaffIc() {
		return StaffIc;
	}
	public void setStaffIc(String staffIc) {
		this.StaffIc = staffIc;
	}
	
	
	
}
