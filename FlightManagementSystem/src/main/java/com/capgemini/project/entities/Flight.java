package com.capgemini.project.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Flight")
public class Flight implements Serializable {
	
	        @Id
	        @Column(length=10)
	        String FlightNumber;
	        String carrierName;
	        String flightModel;
	        
	        @Column(length=4)
	        int seatCapacity;
	        
	        public Flight() {}
	        
	        public Flight(String FlightNumber) {
	        	
	        	  this.FlightNumber=FlightNumber;
	        }
	        
	        public Flight(String FlightNumber,String carrierName,String flightModel,int seatCapacity) {
	        	
	        	
	        	    this.FlightNumber=FlightNumber;
	        	    this.carrierName=carrierName;
	        	    this.flightModel=flightModel;
	        	    this.seatCapacity=seatCapacity;
	        	    
	        }
	        
			public String getFlightNumber() {
				return FlightNumber;
			}
			public void setFlightNumber(String flightNumber) {
				FlightNumber = flightNumber;
			}
			public String getCarrierName() {
				return carrierName;
			}
			public void setCarrierName(String carrierName) {
				this.carrierName = carrierName;
			}
			public String getFlightModel() {
				return flightModel;
			}
			public void setFlightModel(String flightModel) {
				this.flightModel = flightModel;
			}
			public int getSeatCapacity() {
				return seatCapacity;
			}
			public void setSeatCapacity(int seatCapacity) {
				this.seatCapacity = seatCapacity;
			}
	        

}
