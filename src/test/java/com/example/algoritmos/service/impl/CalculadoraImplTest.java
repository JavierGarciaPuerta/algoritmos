package com.example.algoritmos.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.algoritmos.service.CalculadoraService;

public class CalculadoraImplTest {

	private CalculadoraService calculadoraService;
	
	@Before
	public void setUp() {
		calculadoraService = new CalculadoraServiceImpl();
	}
	
	@Test
	public void happyPathTest() {
		Integer resultado = calculadoraService.resta(3, 2);
		assertThat(resultado).isEqualTo(1);
		
	}
	
	@Test
	public void unHappyPathTest() {
		Integer resultado = calculadoraService.resta(3, 2);
		assertThat(resultado).isNotEqualTo(2);
	}

}
