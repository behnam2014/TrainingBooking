package com.behnam.trainingsbooking.model;

import java.time.LocalDate;
import java.time.Period;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;


@Data
@Entity
public class Appointment {
	
	
	private @Id @GeneratedValue Long id;
	public static final int CAPACITY = 10;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int period = 0;
	private int capacity = 10;
	
	
	public Appointment(LocalDate startDate, LocalDate endDate) {
		  
	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.setPeriod();
    }
	
	public Appointment() {
	
	}
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod() {

		this.period = Period.between(startDate,endDate).getDays();

	}

	public Long getId() {
		return id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	



}