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
	private String training;
	private String appoinment;
	
	
	public Booking(String user, String training,String appoinment) {
		  
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

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getAppoinment() {
		return appoinment;
	}

	public void setAppoinment(String appoinment) {
		this.appoinment = appoinment;
	}

	
	
}