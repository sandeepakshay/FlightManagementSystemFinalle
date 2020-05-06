package com.capgemini.project.entities;

import javax.persistence.Column;

public class Search {

	    
	    public Airport sourceAirport;
	    
	    @Column(length=25)
	    public String DeparturTime;
	    
	    public Airport destinationAirport;
	    
	    
		public Airport getSourceAirport() {
			return sourceAirport;
		}
		public void setSourceAirport(Airport sourceAirport) {
			this.sourceAirport = sourceAirport;
		}
		public String getDeparturTime() {
			return DeparturTime;
		}
		public void setDeparturTime(String departurTime) {
			DeparturTime = departurTime;
		}
		public Airport getDestinationAirport() {
			return destinationAirport;
		}
		public void setDestinationAirport(Airport destinationAirport) {
			this.destinationAirport = destinationAirport;
		}
	    
	    
}
