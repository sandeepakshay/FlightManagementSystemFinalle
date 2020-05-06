package com.capgemini.project.entities;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Schedule")
public class Schedule implements Serializable {

    @Id
    @SequenceGenerator(name = "MY_ENTITY_SEQ", sequenceName = "MY_ENTITY_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "MY_ENTITY_SEQ" )
	public int ScheduleId;

	@ManyToOne
	@JoinColumn(name = "SourceAirportCode", referencedColumnName = "AirportCode")
	public Airport sourceAirport;

	@ManyToOne
	@JoinColumn(name = "DestAirportCode", referencedColumnName = "AirportCode")
	public Airport destinationAirport;

	
	public LocalTime ArrivalTime;
	
	
	public LocalTime DepartureTime;

	@JoinColumn(name = "flight", referencedColumnName = "FlightNumber")
	@ManyToOne(optional = false)
	Flight flight;

	@Column(length=10)
	int availableSeats;

	@Column(length=10)
	int ticketCost;
	


	
	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Schedule() {
	}

	public Schedule(int ScheduledId) {

		this.ScheduleId = ScheduleId;

	}

	public Schedule(int ScheduleId, Airport sourceAirport, Airport destinationAirport,LocalTime ArrivalTime,
			LocalTime DepartureTime, Flight flight, int availableSeats, int ticketCost) {

		this.ScheduleId = ScheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;

		this.ArrivalTime = ArrivalTime;
		this.DepartureTime = DepartureTime;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.ticketCost = ticketCost;

	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getScheduleId() {
		return ScheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.ScheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalTime getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.ArrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.DepartureTime = departureTime;
	}

}
