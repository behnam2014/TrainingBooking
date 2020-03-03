package com.behnam.trainingsbooking.repository;

import com.behnam.trainingsbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}