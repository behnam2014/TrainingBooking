package com.behnam.trainingsbooking.repository;

import com.behnam.trainingsbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}