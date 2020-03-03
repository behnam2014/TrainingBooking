package com.behnam.trainingsbooking.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.behnam.trainingsbooking.model.Appointment;
import com.behnam.trainingsbooking.model.Training;
import com.behnam.trainingsbooking.repository.TrainingRepository;

/**
 * @author ghavi
 *
 */

@RestController
@RequestMapping("/api")
public class TrainingController {

	@Autowired
	private TrainingRepository trainingRepository;

	// http://localhost:8080/api/trainings
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/trainings", produces = { "application/json ; charset=utf-8" })
	public List<Training> getAllTraining() {

		return trainingRepository.findAll();

	}

	/**
	 * Gets training by id.
	 *
	 * @param trainingId
	 *            the training id
	 * @return the training by id
	 * @throws ResourceNotFoundException
	 *             the resource not found exception
	 */

	// http://localhost:8080/api/training/1
	@GetMapping("/training/{id}")
	public ResponseEntity<Training> getTrainingsById(@PathVariable(value = "id") Long trainingId)

			throws Exception {
		Training training = trainingRepository.findById(trainingId)
				.orElseThrow(() -> new Exception("training not found on :: " + trainingId));

		return ResponseEntity.ok().body(training);

	}

	// http://localhost:8080/api/trainings?startdate=2020-05-04&enddate=2020-06-04
	@RequestMapping(value = "/trainings", params = { "startdate", "enddate" })
	@ResponseBody
	public List<Training> getTrainingWithparameter(@RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate) {
		LocalDate localDateStart = LocalDate.parse(startdate);
		LocalDate localDateEnd = LocalDate.parse(enddate);

		List<Training> traininglist = new ArrayList<>();

		trainingRepository.findAll().stream().forEach(training -> {

			for (Appointment app : training.getAppointments()) {

				if (overlap(app.getEndDate(), app.getEndDate(), localDateStart, localDateEnd)) {
					traininglist.add(training);
					break;
				}
			}
		});

		return traininglist;
	}

	private boolean overlap(LocalDate sdate1, LocalDate edate1, LocalDate sdate2, LocalDate edate2) {
		if ((sdate2.isEqual(sdate1) || sdate2.isBefore(sdate1)) && (edate2.isEqual(edate1) || edate2.isAfter(edate1)))
			return true;
		return false;
	}

	@PostMapping("/training")
	Training newTraining(@RequestBody Training newTraining) {
		return trainingRepository.save(newTraining);
	}

	@PutMapping("/training/{id}")
	Training replaceTraining(@RequestBody Training newTraining, @PathVariable Long id) {

		return trainingRepository.findById(id).map(training -> {
			training.setName(newTraining.getName());
			
			return trainingRepository.save(training);
		}).orElseGet(() -> {
			return trainingRepository.save(newTraining);
		});
	}

	@DeleteMapping("/training/{id}")
	void deleteTraining(@PathVariable Long id) {
		trainingRepository.deleteById(id);
	}

}
