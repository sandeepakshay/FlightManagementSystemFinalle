package com.capgemini.project.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.project.entities.Schedule;
import com.capgemini.project.entities.ScheduledFlight;
import com.capgemini.project.entities.Search;
import com.capgemini.project.entities.Users;
import com.capgemini.project.exceptions.AirportException;
import com.capgemini.project.exceptions.FlightException;
import com.capgemini.project.exceptions.ScheduleException;
import com.capgemini.project.exceptions.SearchNotFoundException;
import com.capgemini.project.services.ScheduleService;
import com.capgemini.project.services.ScheduleServiceImp;



/***************************************************************************************
 *          @author          k karteek sandeep akshay
 *          Description      It is a Controller class that provides the End points for adding new schedule flight, 
                              viewing all the scheduledFlights,update it,delete them and also to search
  
 ***************************************************************************************/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
	
	

	@Autowired
	ScheduleService Schedule_service;
	

	
/*************************************************************************************
    * Method              - add
    *Description          - To schedule a flight 
    * parameter- schedule - schedule object to schedule a flight
    *Created By            - k karteek sandeep akshay                           

**************************************************************************************/
	@PostMapping("/addSchedule")
	public ResponseEntity<Object> add(@Valid @RequestBody Schedule schedule) {
		
		

		Schedule_service.add(schedule);
		return new ResponseEntity<>("You have scheduled a new flight", HttpStatus.OK);
}
	

      
/**********************************************************************************
     * Method              - displayAirportCode
     *Description          - To view a All airport codes 
     *Created By            - k karteek sandeep akshay                           
 
 *********************************************************************************/
	@GetMapping("/viewAirportCode")
	public ResponseEntity<Object> displayAirportCode() throws AirportException {

	

			if (Schedule_service.viewAirportCode() == null)
				throw new AirportException("No Airports Available");
			else
				return new ResponseEntity<>(Schedule_service.viewAirportCode(), HttpStatus.OK);
		
}
	
	
	
/********************************************************************************
     * Method              - displayFlightNum
     *Description          - To view a All Flight Numbers 
     *Created By            - k karteek sandeep akshay                           
 
********************************************************************************/    	
    @GetMapping("/viewFlightNum")
	public ResponseEntity<Object> displayFlightNum() throws FlightException {



			if (Schedule_service.viewFlightNum() == null)
				throw new FlightException("No Flights Added");
			else
				return new ResponseEntity<>(Schedule_service.viewFlightNum(), HttpStatus.OK);
		
}
    
    
    
/*********************************************************************************
     * Method              - displayScheduleIds
     *Description          - To view a Only the Schedule Ids 
     *Created By           - k karteek sandeep akshay                           
 
 **********************************************************************************/        
    @GetMapping("/viewScheduleIds")
	public ResponseEntity<Object> displayScheduleIds() {

		return new ResponseEntity<>(Schedule_service.viewScheduleIds(), HttpStatus.OK);
}
    

    
/********************************************************************************
     * Method              - displayAllSchedule
     *Description          - To view a All the Scheduled Flights 
     *Created By            - k karteek sandeep akshay                           
 
 *******************************************************************************/	      
    @GetMapping("/viewAllSchedule")
	public ResponseEntity<Object> displayAllSchedule() {

		return new ResponseEntity<>(Schedule_service.viewAllSchedule(), HttpStatus.OK);
}
    
    
  
/***********************************************************************************
     * Method              - displayById
     *Description          - To find a particular scheduled flight by ID
     *@param - id          - Schedule id that we want to find it out
     *Created By            - k karteek sandeep akshay                           

 ***********************************************************************************/  
	@GetMapping("/viewById/{id}")
	public ResponseEntity<Object> displayById(@PathVariable("id") int id) throws ScheduleException {

	

			if (Schedule_service.findById(id) == null)
				throw new ScheduleException("No Scheduled flight with entered ID is found");
			else
				return new ResponseEntity<>(Schedule_service.findById(id), HttpStatus.OK);
		
}
	

	

/**********************************************************************************
     * Method                   - update
     *Description               - To update a particular scheduled flight by ID
     *@param - id               - Schedule id that you want to update
     *@RequestBody - schedule   -Request body that to be updated
     *Created By                - k karteek sandeep akshay                           

 *********************************************************************************/  	
    @PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody Schedule schedule) {

		Schedule_service.update(id, schedule);
		return new ResponseEntity<>( HttpStatus.OK);
}
    

   
    
/*******************************************************************************
     * Method              - delete
     *Description          - To delete a particular scheduled flight
     *@param - id          - Schedule id that we want to delete
     *Created By            - k karteek sandeep akshay                           

 *********************************************************************************/           
    @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Object> delete(@PathVariable int id) {

		Schedule_service.delete(id);
		return new ResponseEntity<>("Scheduled Flight with"+id+" deleted", HttpStatus.OK);

}

    
    
    
/*************************************************************************************
     * Method              - search
     *Description          - To search a Scheduled flight
     *@RequestBody search  - Request body that provides departure time,source and destination airport codes 
                              to search
     *Created By            - k karteek sandeep akshay                           

 *************************************************************************************/          
    @PostMapping("/search")
	public ResponseEntity<Object> search(@RequestBody Search search) throws SearchNotFoundException {


			if (Schedule_service.searchScheduledFlights(search).isEmpty())
				throw new SearchNotFoundException("No Search Results!");
			else
				return new ResponseEntity<>(Schedule_service.searchScheduledFlights(search), HttpStatus.OK);
	

	}
    
    
    
    
    
    
    
    
    
	
//	@PostMapping("/login")
//	public ResponseEntity<Object> loginAdmin(@RequestBody String UserName, String password ){
//		
//		
//		      
//		      return new ResponseEntity<>(Schedule_service.loginAdmin(UserName, password), HttpStatus.OK);
//		      
//	}
	
	

}
