package com.behnam.trainingsbooking.repository;

import com.behnam.trainingsbooking.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}