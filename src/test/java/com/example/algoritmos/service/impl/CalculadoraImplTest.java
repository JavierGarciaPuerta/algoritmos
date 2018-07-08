package com.example.algoritmos.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.algoritmos.bean.InputBean;
import com.example.algoritmos.service.CalculadoraService;

public class CalculadoraImplTest {

	private CalculadoraService calculadoraService;
	
	@Before
	public void setUp() {
		calculadoraService = new CalculadoraServiceImpl();
	}
	
	@Test
	public void happyPathTest() {
		InputBean input = new InputBean(3, 2);
		Integer resultado = calculadoraService.resta(input);
		assertThat(resultado).isEqualTo(1);
		
	}
	
	@Test
	public void unHappyPathTest() {
		InputBean input = new InputBean(3, 2);
		Integer resultado = calculadoraService.resta(input);
		assertThat(resultado).isNotEqualTo(2);
	}
	
	@Test
	public void happyPathTestAdd() {
		Integer resultado = calculadoraService.suma(5, 6);
		assertThat(resultado).isEqualTo(11);
	}
	
	@Test
	public void unHappyPathTestAdd() {
		Integer resultado = calculadoraService.suma(1, 2);
		assertThat(resultado).isNotEqualTo(2);
	}

}
