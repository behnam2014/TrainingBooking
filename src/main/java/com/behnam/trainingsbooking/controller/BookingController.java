package com.behnam.trainingsbooking.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.behnam.trainingsbooking.model.Booking;
import com.behnam.trainingsbooking.repository.BookingRepository;


/**
 * @author ghavi
 *
 */

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;


	@CrossOrigin(allowedHeaders = "index.html")
	@GetMapping(value = "/bookings", produces = { "application/json ; charset=utf-8" })
	public List<Booking> getAllTraining() {

		return bookingRepository.findAll();

	}


	HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {/**
			 * 
			 */
			private static final long serialVersionUID = 1279744571769974553L;

		{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}
	
		
	@CrossOrigin(origins = "*")
	@PostMapping(value="/booking",consumes = "application/json", produces = "application/json")
	Booking newTraining(@RequestBody Booking newBooking) {
		return bookingRepository.save(newBooking);
	}

			 
	@PostMapping(
	  value = "/updateBooking", consumes = "application/json", produces = "application/json")
	public Booking updateBooking(@RequestBody Booking booking, HttpServletResponse response) {
	    response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
	      .path("/findPerson/" + booking.getId()).toUriString());
	     
	    return bookingRepository.saveAndFlush(booking);
	}
	

}
