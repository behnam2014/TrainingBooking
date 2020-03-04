package com.behnam.trainingsbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Booking {
	
	
	private @Id @GeneratedValue Long id;
	
	private String user;
	private Long training;
	private Long appoinment;
	
	
	public Booking(String user, Long training, Long appoinment) {
		  
		  this.setUser(user);
		  this.setTraining(training);
		  this.setAppoinment(appoinment);
	}
	
    public Booking(){
    	
    }

	public Long getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getTraining() {
		return training;
	}

	public void setTraining(Long training) {
		this.training = training;
	}

	public Long getAppoinment() {
		return appoinment;
	}

	public void setAppoinment(Long appoinment) {
		this.appoinment = appoinment;
	}

	
	
}