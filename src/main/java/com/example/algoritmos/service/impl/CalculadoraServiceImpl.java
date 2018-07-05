package com.example.algoritmos.service.impl;

import org.springframework.stereotype.Service;

import com.example.algoritmos.service.CalculadoraService;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {
	
	@Override
	public Integer resta(Integer a, Integer b) {
		Integer resultado = a-b;
		return resultado;
	}

}
