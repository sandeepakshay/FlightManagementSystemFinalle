package com.capgemini.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Airport")
public class Airport implements Serializable {
	
	      
	       String AirportName;
	       
	       @Id
	       @Column(length=5)
	       String AirportCode;
	       
	       @Column(length=25)
	       String AirportLocation;
	       
	        public Airport() {}    
	       
	        public Airport(String AirportCode) {
	    	
	    	
	    	this.AirportCode=AirportCode;
	    	
	    	
	    	
	    }
		public String getAirportName() {
			return AirportName;
		}
		public void setAirportName(String airportName) {
			AirportName = airportName;
		}
		public String getAirportCode() {
			return AirportCode;
		}
		public void setAirportCode(String airportCode) {
			AirportCode = airportCode;
		}
		public String getAirportLocation() {
			return AirportLocation;
		}
		public void setAirportLocation(String airportLocation) {
			AirportLocation = airportLocation;
		}
	       
	       

}
