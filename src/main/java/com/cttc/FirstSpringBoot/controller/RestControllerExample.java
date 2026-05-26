package com.cttc.FirstSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RestControllerExample {

	@GetMapping("/home")
	public String goToHome() {
		return "hello cttc";
	}
	
	@PostMapping("/save")
	public String postMethodName(@RequestBody String name) {
		System.out.println(name);
		return "hello " + name;
	}
	

}
