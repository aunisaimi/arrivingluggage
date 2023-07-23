package arriving.luggage.flight.arrivingluggage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arriving.luggage.flight.arrivingluggage.model.Staff;
import arriving.luggage.flight.arrivingluggage.repository.StaffRepository;

@RestController
@RequestMapping ("/api/staffs")
public class StaffRestController {

		@Autowired
		private StaffRepository staffRepository;
		@GetMapping
		public List<Staff> getStaff(){
			return staffRepository.findAll();	
		}
		
		@GetMapping("{StaffId}")
		public Staff getStaff(@PathVariable long StaffId)
		{
			Staff staff = staffRepository.findById(StaffId).get();
			return staff;
		}	
}
