package com.behnam.trainingsbooking.utils;

import lombok.extern.slf4j.Slf4j;
import com.behnam.trainingsbooking.model.Appointment;

import com.behnam.trainingsbooking.model.Teacher;
import com.behnam.trainingsbooking.model.Training;
import com.behnam.trainingsbooking.model.User;
import com.behnam.trainingsbooking.repository.BookingRepository;
import com.behnam.trainingsbooking.repository.TrainingRepository;
import com.behnam.trainingsbooking.repository.UserRepository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Slf4j
@Component
public class DatabaseInitializer {

	private final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);
	
	@Autowired 
	BookingRepository bookingrepository;
	
	@Autowired 
	UserRepository userrepository;
	

	@Bean
	@Transactional
	CommandLineRunner initDatabase(TrainingRepository repository) {
		

		Training t1 = new Training();

		t1.getAppointments().add(new Appointment(LocalDate.of(2020, 3, 1), LocalDate.of(2020, 3, 14)));
		t1.getAppointments().add(new Appointment(LocalDate.of(2020, 3, 18), LocalDate.of(2020, 4, 5)));
		t1.getTeachers().add(new Teacher("Behnam Ghavimi"));
		t1.setPrice("750");
		t1.setName("python 2 and 3");
		t1.setDescription("Der Kurs 'Python 2 and 3' richtet sich vor "
				+ "allem an Anfänger, die das Programmieren erlernen wollen.");

		Training t2 = new Training();

		t2.getAppointments().add(new Appointment(LocalDate.of(2020, 3, 1), LocalDate.of(2020, 3, 14)));
		t2.getAppointments().add(new Appointment(LocalDate.of(2020, 5, 04), LocalDate.of(2020, 05, 15)));
		t2.getTeachers().add(new Teacher("Alex Musterman"));
		t2.setPrice("900");
		t2.setName("Javascript for beginners");
		t2.setDescription("Der Kurs richtet sich vor " + "allem an Anfänger, die das WEB Programmieren lernen wollen.");
		
		
		return args -> {
			
			logger.info("Preloading " + repository.save(t1));
			logger.info("Preloading " + repository.save(t2));
			logger.info("Preloading " + userrepository.save(new User("Max","Muster", "ghavimi.behnam@gmail.com")));
		
		};

	}

}
