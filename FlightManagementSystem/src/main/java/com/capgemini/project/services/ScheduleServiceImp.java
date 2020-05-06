package com.capgemini.project.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.project.Dao.ScheduleDao;
import com.capgemini.project.Dao.ScheduleDaoImp;
import com.capgemini.project.entities.Airport;
import com.capgemini.project.entities.Flight;
import com.capgemini.project.entities.Schedule;
import com.capgemini.project.entities.ScheduledFlight;
import com.capgemini.project.entities.Search;
import com.capgemini.project.entities.Users;


/*****************************************************************************************
 *          @author          k karteek sandeep akshay
 *          Description      It is a Service class that provides the services for adding new schedule flight, 
                              viewing all the scheduledFlights,update it,delete them and also to search  
  
 ****************************************************************************************/
@Transactional
@Service
public class ScheduleServiceImp implements ScheduleService {

	@Autowired
	ScheduleDao Schedule_dao;

	public void add(Schedule schedule) {

		Schedule_dao.add(schedule);
	}


	public List<Object> viewAirportCode() {

		return Schedule_dao.viewAirportCode();
	}

	public List<Object> viewFlightNum() {

		return Schedule_dao.viewFlightNum();
	}

	public List<Object> viewScheduleIds() {

		return Schedule_dao.viewScheduleIds();
	}

	public List<Schedule> viewAllSchedule() {

		return Schedule_dao.viewAllSchedule();
	}

	public void delete(int id) {

		Schedule_dao.delete(id);
	}

	public void update(int id, Schedule schedule) {

		Schedule_dao.update(id, schedule);
	}

	public Schedule findById(int id) {

		return Schedule_dao.findById(id);
	}

	public List<Schedule> searchScheduledFlights(Search search) {

		return Schedule_dao.searchScheduledFlights(search);
	}
	
//	public Users loginAdmin(String UserName,String password) {
//		
//		   return Schedule_dao.loginAdmin(UserName, password);
//	}

}
