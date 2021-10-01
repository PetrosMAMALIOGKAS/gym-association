package com.simplon.gym.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.gym.dao.SportifDao;
import com.simplon.gym.dao.SportifDocumentMapper;
import com.simplon.gym.model.Sportifs;

@Service
public class SportifService {
	
	@Autowired
	private final SportifDao sportifDao;
	
	private static Logger log = LoggerFactory.getLogger(SportifDocumentMapper.class.getName());
	

	public SportifService( SportifDao sportifDao )
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
	   
	   return sportifs;
	}
	
	public int addSportif( Map<String, Object> body ) {
		System.out.println(body.toString() + "************ service *************");
		  
		int result = sportifDao.addSportif(body);
		
		if (result  == -1 ) {
			
			log.warn("Unable to add document `{}` to `Sportifs` collection: {} ");
			return -1;
		}
		return 1;
	}
	
	public Sportifs getSportifByIdSportif( String IdSportif ) {
		System.out.println(IdSportif.toString() + "************ service *************");
		
		sportifDao.getSportifByIdSportif(IdSportif);
		
		
		
		Sportifs sportif = new Sportifs();
		sportif = sportifDao.getSportifByIdSportif(IdSportif);
		return sportif;
	}

}
