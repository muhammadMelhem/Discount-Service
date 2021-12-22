package com.company;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.company.controller.DiscountController;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(DiscountController.class)
public class DiscountControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	DiscountController discountController;

	@Test
	public void calculateTest() throws Exception {

		Double expectedValueTest1 = 52.85;
		Double expectedValueTest2 = 496.78000000000003;

		mockMvc.perform(MockMvcRequestBuilders.get("/api/discountService/calculate?bill=75.5&userId=4")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(result -> is(expectedValueTest1));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/discountService/calculate?bill=524.2&userId=1")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(result -> is(expectedValueTest2));

	}

}