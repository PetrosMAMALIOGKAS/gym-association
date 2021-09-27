package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.SportifDao;
import model.Sportif;

@Service
public class SportifService {
	
	private final SportifDao sportifDao;
	
	@Autowired
	public SportifService(@Qualifier("SportifAccessDao") SportifDao sportifDao)
	{
		this.sportifDao = sportifDao;
	}

	public List<Sportif> getAllSportifs() 
	{
		return sportifDao.getAllSportifs();
	}

}
