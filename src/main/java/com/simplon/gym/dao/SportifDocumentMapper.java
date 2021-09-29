package com.simplon.gym.dao;

import java.util.ArrayList;
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
        	try {
        		sports.setJouer((List<String>) document.get("Jouer"));
        		
        	} catch (Exception e) {
        		
        		List<String> jouer = new ArrayList<>();
        		jouer.add( (String) document.get("Jouer"));
        		sports.setJouer(jouer);
        	}
        }
        
        if (document.containsKey("Arbitrer")) {
        	try {
            	sports.setArbitrer((List<String>) document.get("Arbitrer"));
        	} catch (Exception e) {
        		
        		List<String> arbitrer = new ArrayList<>();
        		arbitrer.add( (String) document.get("Arbitrer"));
        		sports.setArbitrer(arbitrer);
        	}
        }
        
        if (document.containsKey("Entrainer")) {
        	try {
        		sports.setEntrainer((List<String>) document.get("Entrainer"));
        	} catch (Exception e) {
        		
        		List<String> entrainer = new ArrayList<>();
        		entrainer.add( (String) document.get("Entrainer"));
        		sports.setArbitrer(entrainer);
        	}
        	
        }
 
        return sports;
    }

}
