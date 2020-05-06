package com.capgemini.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger implements Serializable {
	
	          @Id
	          @Column(length=15)
	          long pnrNumber;
	          
	          @Column(length=25)
	          String passengerName;
	          
	          @Column(length=3)
	          int passengerAge;
	          double luggage;
	          
	          
			public long getPnrNumber() {
				return pnrNumber;
			}
			public void setPnrNumber(long pnrNumber) {
				this.pnrNumber = pnrNumber;
			}
			public String getPassengerName() {
				return passengerName;
			}
			public void setPassengerName(String passengerName) {
				this.passengerName = passengerName;
			}
			public int getPassengerAge() {
				return passengerAge;
			}
			public void setPassengerAge(int passengerAge) {
				this.passengerAge = passengerAge;
			}
			public double getLuggage() {
				return luggage;
			}
			public void setLuggage(double luggage) {
				this.luggage = luggage;
			}
	          
	          
	      

}
