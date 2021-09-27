package control;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import model.Sportif;
import service.SportifService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/sportifs")
public class SportifControl {
	
	@Autowired
	SportifService sportifService;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Sportif> getAllSportifs() throws IOException {
		
		return sportifService.getAllSportifs();
	}

}
