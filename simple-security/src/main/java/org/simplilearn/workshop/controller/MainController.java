package org.simplilearn.workshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
	@GetMapping("/")
	public String helloSecurity() {
		return "Welcome, you logged in successfully - Secured";
	}
}
