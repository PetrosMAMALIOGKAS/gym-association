package com.simplon.gym.control;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.gym.model.Sportifs;
import com.simplon.gym.service.SportifService;

@RestController
public class HelloControl {
	
	@Autowired
	private SportifService sportifService;
	
	@GetMapping("/hello")
	public String getAllSportifst()  {
		
		System.out.println("ttt");
		return "Hello world!!";
	}
	
	@GetMapping("/sport")
	public List<Sportifs> getAllSportifs()  {
		
		System.out.println("ddd hello");
		return sportifService.getAllSportifs();
	}

}
