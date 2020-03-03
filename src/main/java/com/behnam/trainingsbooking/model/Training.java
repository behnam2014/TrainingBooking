package com.behnam.trainingsbooking.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.behnam.trainingsbooking.model.Appointment;
import com.behnam.trainingsbooking.model.Teacher;

import lombok.Data;

@Data
@Entity
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	private List<Appointment> appointments= new ArrayList<>();

	private String description;

	private String name;

	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	private Set<Teacher> teachers = new HashSet<>();

	private String price;

	public Training() {
	}

	public Training(String name, List<Appointment> appointments, String description, Set<Teacher> teachers,
			String price) {

		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
		this.setTeachers(teachers);
		this.setAppointments(appointments);


	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Long getId() {
		return id;
	}
	
	


}
