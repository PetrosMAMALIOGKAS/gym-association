package com.simplon.gym.control;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.gym.model.Sportifs;
import com.simplon.gym.service.SportifService;


@RequestMapping(path = "/sportifs")
@RestController
public class SportifsControl {
	
	@Autowired
	private SportifService sportifService;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Sportifs> getAllSportifs()  {
		
		return sportifService.getAllSportifs();
	}
	
	
	@GetMapping(value = "/idsportif/{idSportif}")
    public  @ResponseBody String getSportifByIdSportif(@PathVariable(value = "idSportif") String IdSportif) {
		System.out.println(IdSportif.toString() + "************ control avant*************");
		HashMap<String, Object> result = new HashMap<>();
        Sportifs sportif = sportifService.getSportifByIdSportif(IdSportif);
        System.out.println(IdSportif.toString() + "************ control apres*************");
//        if (movie == null) {
//            result.put("error", "Not found");
//            return ResponseEntity.badRequest().body(result);
//        }
//
//        result.put("movie", movie);
//        result.put("api", "java");
//        result.put("updated_type", moviesService.getMovieDocumentFieldType(movieId, "lastupdated"));
//        return ResponseEntity.ok(result);
		  return IdSportif;
    }
	
	@PostMapping("/add")
	public @ResponseBody String addSportif(@RequestBody Map<String, Object> body)   //(@RequestBody Sportifs sportif)
	{	
	    
	  int result = sportifService.addSportif(body);
	  System.out.println(body.toString() + "************ control *************");
	  
	  if (result == -1) {
		  return "Sportif Not Saved: there was an error";
	  }
	  return "Sportif Saved";
	}

}
