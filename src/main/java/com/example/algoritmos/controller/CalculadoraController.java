package com.example.algoritmos.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.algoritmos.service.CalculadoraService;

public class CalculadoraController {
	
	private CalculadoraService calculadoraService;
	
	@Autowired
	public CalculadoraController(CalculadoraService calculadora) {
		this.calculadoraService = calculadora;
	}
	
	public Integer realizarResta(Integer a, Integer b) {
		return calculadoraService.resta(a, b);
		
	}
	
}
