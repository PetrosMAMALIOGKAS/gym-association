package com.simplon.gym.dao;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplon.gym.model.Sportifs;
import com.simplon.gym.model.Sports;

@SuppressWarnings("unchecked")
public class SportifDocumentMapper {
	
	private static Logger log = LoggerFactory.getLogger(SportifDocumentMapper.class.getName());
	
	
	public static Sportifs mapToSportif(Bson bson) {

        Sportifs sportif = new Sportifs();
        Document document = (Document) bson;
        try {
        	sportif.setId(document.get("_id").toString());
        	sportif.setIdSportif(document.get("IdSportif").toString());
        	sportif.setNom(document.get("Nom").toString());
        	sportif.setPrenom(document.get("Prenom").toString());
        	sportif.setSexe(document.get("Sexe").toString());
        	sportif.setAge(document.get("Age").toString());

            if (document.containsKey("Sports")) {
            	sportif.setSports(mapToSports((Document) document.get("Sports")));
            }

        } catch (Exception e) {
            log.warn("Unable to map document `{}` to `Sportifs` object: {} ", document, e.getMessage());
            log.warn("Skipping document");
        }
        
        return sportif;
    }
	
	private static Sports mapToSports(Document document) {
		Sports sports = new Sports();
        if (document == null) {
            return sports;
        }
        
        if (document.containsKey("Jouer")) {
        	sports.setJouer((List<String>) document.get("Jouer"));
        }
        
        if (document.containsKey("Arbitrer")) {
        	sports.setArbitrer((List<String>) document.get("Arbitrer"));
        }
        
        if (document.containsKey("Entrainer")) {
        	sports.setEntrainer((List<String>) document.get("Entrainer"));
        }
 
        return sports;
    }

}
