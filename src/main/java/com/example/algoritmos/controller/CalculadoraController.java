package com.example.algoritmos.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.algoritmos.bean.InputBean;
import com.example.algoritmos.service.CalculadoraService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CalculadoraController {
	
	private CalculadoraService calculadoraService;
	
	//No es necesario
	//@Autowired
	public CalculadoraController(CalculadoraService calculadora) {
		this.calculadoraService = calculadora;
	}
	
	@GetMapping("/resta/{uno}/{dos}")
	public Integer realizarResta(@PathVariable Integer one, @PathVariable Integer two) {
		return calculadoraService.resta(new InputBean(one, two));
		
	}
	
	@RequestMapping("/resta2")
	public Integer realizarResta2(@RequestParam(name="uno") Integer one, @RequestParam(name="dos") Integer two) {
		InputBean inputBean = new InputBean(one, two);
		return calculadoraService.resta(inputBean);
		
	}
	
	@GetMapping("/suma/{uno}/{dos}")
	public Integer realizarSuma(@PathVariable Integer uno, @PathVariable Integer dos){
		return calculadoraService.suma(uno, dos);
	}
	
	@RequestMapping("/operacion/{sueldo}")
	public Integer realizarOperacion(@PathVariable Integer sueldo) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String fooResourceUrl = "http://localhost:8080/resta/"+sueldo+"/20";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
		
		Integer sueldoRestado=Integer.valueOf(response.getBody());
		
		fooResourceUrl = "http://localhost:8090/multiplicar/"+sueldoRestado+"/2";
		response = restTemplate.getForEntity(fooResourceUrl, String.class);
		
		System.out.println("Este es el valor devuleto=>"+response.getBody());
		
		return Integer.valueOf(response.getBody());
	}
	
	
}
