package arriving.luggage.flight.arrivingluggage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class is the staff model representing staff information.
 * 
 * This class is mapped to a database table named "staff" using JPA annotations.
 * It represents information about a staff member, 
 * including their unique ID, name, and IC/ passport.
 * 
 * @author Anis Sabrina
 * 
 */

//Maps this class to a database table named "staff"
@Entity
@Table(name = "staff") 
public class Staff {
    
    // Primary Key
    @Id
    // Specifies that the staffID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Column representing the staff id
    @Column(name = "staffID")
    private int staffID;
    
    // Column representing the staff's name
    @Column(name = "staffName")
    private String staffname;
    
    // Column representing the staff's IC/ passport
    @Column(name = "staffIC")
    private String staffIC;

    // Getter and Setter methods

    // Get the staff ID
    public int getStaffID() {
        return staffID;
    }

    // Set the staff ID
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    // Get the staff's name
    public String getStaffname() {
        return staffname;
    }

    // Set the staff's name
    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    // Get the staff's IC/ passport
    public String getStaffIC() {
        return staffIC;
    }

    // Set the staff's IC/ passport
    public void setStaffIC(String staffIC) {
        this.staffIC = staffIC;
    }
    
}
