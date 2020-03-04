package com.behnam.trainingsoffer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.behnam.trainingsbooking.controller.TrainingController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class TrainingsofferApplicationTests {

	 
	@Autowired
	private MockMvc mvc;
	
	 
	@Test
	public void getAllEmployeesAPI() throws Exception 
	{

		 mvc.perform( MockMvcRequestBuilders
			      .get("/api/training/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(MockMvcResultHandlers.print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.appointments").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.appointments[*].id").isNotEmpty());
		
	}
}
