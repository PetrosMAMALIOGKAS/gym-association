package com.simplon.gym.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.gym.dao.SportifDao;
import com.simplon.gym.dao.SportifDocumentMapper;
import com.simplon.gym.model.Sportifs;

@Service
public class SportifService {
	
	@Autowired
	private final SportifDao sportifDao;
	

	public SportifService(SportifDao sportifDao)
	{
		this.sportifDao = sportifDao;
	}

	public List<Sportifs> getAllSportifs() 
	{
	   List<Sportifs> sportifs =
                sportifDao
	                .getAllSportifs()
	                .stream()
	                .map(SportifDocumentMapper::mapToSportif)
	                .collect(Collectors.toList());
	   
	   System.out.println("service rrrrr");
	   return sportifs;
	}

}
