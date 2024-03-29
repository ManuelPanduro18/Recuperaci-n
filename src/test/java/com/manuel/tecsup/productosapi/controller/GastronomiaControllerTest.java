package com.manuel.tecsup.productosapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)


@AutoConfigureMockMvc
public class GastronomiaControllerTest {
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getGastronomia() throws Exception{
		int ID_FIRST_RECORD = 1;
		this.mockMvc.perform(get("/gastronomias"))
		.andExpect(status().isOk())
		.andExpect(content()
		.contentType(MediaType.APPLICATION_JSON_UTF8))
	// .andExpect(jsonPath("$", hasSize(NRO_RECORD)))
		.andExpect(jsonPath("$[0].id", is(ID_FIRST_RECORD)));
	}
	
	@Test
	public void buscargastronomia() throws Exception {
		String imagen="ceviche.jpg";
		String nombre="Ceviche";
		mockMvc.perform(get("/gastronomias/1"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.imagen", is(imagen)))
				.andExpect(jsonPath("$.nombre", is(nombre)));
	}
}
