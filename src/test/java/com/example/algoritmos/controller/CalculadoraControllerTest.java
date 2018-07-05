package com.example.algoritmos.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.algoritmos.service.CalculadoraService;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraControllerTest {
	
	private CalculadoraController calculadoraController;
	
	@Mock
	private CalculadoraService calculadoraService;

	@Before
	public void setUp () {
		calculadoraController = new CalculadoraController(calculadoraService);
	}
	
	@Test
	public void happyPathTest() {
		Mockito.when(calculadoraService.resta(Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);
		Integer resultado = calculadoraController.realizarResta(3,2);
		assertThat(resultado).isEqualTo(1);
	}
	
	@Test
	public void unHappyPathTest() {
		Mockito.when(calculadoraService.resta(Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);
		Integer resultado = calculadoraController.realizarResta(3,2);
		assertThat(resultado).isNotEqualTo(2);
	}

}
