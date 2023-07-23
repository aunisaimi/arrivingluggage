package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import arriving.luggage.flight.arrivingluggage.repository.StaffRepository;
import arriving.luggage.flight.arrivingluggage.model.Staff;

/**
 * The StaffRestController class represents a RESTful API controller 
 * for managing staff members.
 * 
 * It handles HTTP requests related to staff and communicates 
 * with the StaffRepository to perform CRUD operations on Staff entities.
 * The API endpoints defined in this controller 
 * follow the '/api/staffs' base URL.
 * 
 * @author Syafiqah Nasir
 *
 */
@RestController
@RequestMapping("/api/staffs")
public class StaffRestController {

    @Autowired
    private StaffRepository staffRepository;

    /**
     * Retrieves a list of all staff members.
     * 
     * @return List of Staff objects representing 
     * all staff members in the database.
     */
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    /**
     * Retrieves a specific staff member by its ID.
     * 
     * @param staffId The ID of the staff member to retrieve.
     * @return The Staff object representing the staff member with the given ID, 
     * or null if not found.
     */
    @GetMapping("{staffId}")
    public Staff getStaffById(@PathVariable long staffId) {
        return staffRepository.findById(staffId).orElse(null);
        // Alternatively, handle the case when the staff member is not found 
        //and return a response accordingly.
        // For example: if (staff == null) 
        //{ throw new NotFoundException("Staff member not found"); }
    }
}
