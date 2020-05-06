package com.capgemini.project.Dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.project.entities.Airport;
import com.capgemini.project.entities.Flight;
import com.capgemini.project.entities.Schedule;
import com.capgemini.project.entities.ScheduledFlight;
import com.capgemini.project.entities.Search;
import com.capgemini.project.entities.Users;
import com.capgemini.project.exceptions.ScheduleException;


/************************************************************************************************
 *          @author          k karteek sandeep akshay
 *          Description      It is a DAO class that provides the JPQL and entity manager for adding new schedule flight, 
                              viewing all the scheduledFlights,update it,delete them and also to search  
  
 **************************************************************************************************/
@Repository
public class ScheduleDaoImp implements ScheduleDao {
	
	

	@PersistenceContext
	EntityManager em;
	
	  
	



/*************************************************************************************
	     * Method              - add
         *Description          - To schedule a flight 
	     * parameter- schedule - schedule object to schedule a flight
	     *Created By            - k karteek sandeep akshay                           
	 
**************************************************************************************/
   public void add(Schedule schedule) {
	   
	    	em.persist(schedule);

	}
	
   
	
/**********************************************************************************
     * Method              - viewAirportCode
     *Description          - To view a All airport codes 
     *Created By            - k karteek sandeep akshay                           
 
 *********************************************************************************/
     public List<Object> viewAirportCode() {

		String str = "select Airport_Code from Airport airport";
		Query query = em.createNativeQuery(str);
		List<Object> list = query.getResultList();
		return list;

	}
     
     
/********************************************************************************
      * Method              - viewFlightNum
      *Description          - To view a All Flight Numbers 
      *Created By            - k karteek sandeep akshay                           
  
********************************************************************************/    
     public List<Object> viewFlightNum() {

		String str = "select FlightNumber from Flight flight";
		Query query = em.createQuery(str);
		List<Object> list = query.getResultList();
		return list;

	}
     
     
     
     
 /*********************************************************************************
      * Method              - viewScheduleIds
      *Description          - To view a Only the Schedule Ids 
      *Created By           - k karteek sandeep akshay                           
  
  **********************************************************************************/    
    public List<Object> viewScheduleIds() {

		String str = "select ScheduleId from Schedule schedule";
		Query query = em.createQuery(str);
		List<Object> list = query.getResultList();
		return list;

	}
	
	
	
/********************************************************************************
     * Method              - viewAllSchedule
     *Description          - To view a All the Scheduled Flights 
     *Created By            - k karteek sandeep akshay                           
 
 *******************************************************************************/	
   public List<Schedule> viewAllSchedule() {

		String str = "select schedule from Schedule schedule";
		TypedQuery<Schedule> query = em.createQuery(str, Schedule.class);
		List<Schedule> list = query.getResultList();
		if (list.isEmpty())
			throw new ScheduleException("No Scheduled Flights Found !");
		else
			return list;

	}
   
/*******************************************************************************
    * Method              - delete
    *Description          - To delete a particular scheduled flight
    *parameter - id       - Schedule id that we want to delete
    *Created By            - k karteek sandeep akshay                           

*********************************************************************************/   
   public void delete(int id) {

		Schedule schedule = em.find(Schedule.class, id);
		if (schedule == null)
			throw new ScheduleException("No Such ID found to delete!");
		else
			em.remove(schedule);
}
   
   
   
   
/***********************************************************************************
    * Method              - findById
    *Description          - To find a particular scheduled flight by ID
    *parameter - id       - Schedule id that we want to find it out
    *Created By            - k karteek sandeep akshay                           

***********************************************************************************/  
     public Schedule findById(int id) {

		Schedule schedule = em.find(Schedule.class, id);
		return schedule;
}
     
     
     
/**********************************************************************************
      * Method                   - update
      *Description               - To update a particular scheduled flight by ID
      *parameter - id            - Schedule id that you want to update
      *Parameter - schedule      -Request body that to be updated
      *Created By                - k karteek sandeep akshay                           

  *********************************************************************************/      
    public void update(int id, Schedule schedule) {

		Schedule schedule1 = em.find(Schedule.class, id);
		schedule1.setScheduleId(id);
		schedule1.setFlight(schedule.getFlight());
		schedule1.setSourceAirport(schedule.getSourceAirport());
		schedule1.setDestinationAirport(schedule.getDestinationAirport());
		schedule1.setArrivalTime(schedule.getArrivalTime());
		schedule1.setDepartureTime(schedule.getDepartureTime());
		schedule1.setTicketCost(schedule.getTicketCost());
		schedule1.setAvailableSeats(schedule.getAvailableSeats());
		em.persist(schedule1);

}
    
    
    
/************************************************************************************
     * Method                :searchScheduledFlights
     *Description          - To search a Scheduled flight
     *param - search       - Request body that provides departure time,source and destination airport codes 
                              to search
     *Created By            - k karteek sandeep akshay                           

 *************************************************************************************/      
    public List<Schedule> searchScheduledFlights(Search search) {

		String str = "SELECT schedule from Schedule schedule WHERE :dDate=schedule.DepartureTime OR :sAirport=schedule.sourceAirport AND :dAirport=schedule.destinationAirport";
		TypedQuery<Schedule> query = em.createQuery(str, Schedule.class);
		query.setParameter("dDate", search.DeparturTime);
		query.setParameter("sAirport", search.sourceAirport);
		query.setParameter("dAirport", search.destinationAirport);
		List<Schedule> list = query.getResultList();
		return list;

}
    
//    public Users loginAdmin(String UserName,String password) {
//    	
//    	String str = "SELECT users from Users users WHERE :name=users.UserName AND  :pass=users.password";
//    	TypedQuery<Users> query = em.createQuery(str, Users.class);
//    	query.setParameter("name", UserName);
//    	query.setParameter("pass", password);
//    	Users user=query.getSingleResult();
//    	return user;
//    }

}
