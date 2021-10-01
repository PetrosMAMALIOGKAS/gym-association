package com.simplon.gym.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.simplon.gym.model.Sportifs;


@Repository
public class SportifDao extends AbstractGymDao{
	
	public static String SPORTIF_COLLECTION = "Sportifs";

    private MongoCollection<Document> sportifsCollection;
    
    
    @Autowired
    public SportifDao( MongoClient mongoClient, @Value("${spring.mongodb.database}") String databaseName) {
        super(mongoClient, databaseName);
        this.sportifsCollection = db.getCollection(SPORTIF_COLLECTION);
    }
    
    
    public List<Document> getAllSportifs() {
        
        List<Document> sportifs = new ArrayList<>();

        sportifsCollection
                .find()
                .iterator()
                .forEachRemaining(sportifs::add);

        return sportifs;
    }
    
    
    public Sportifs getSportifByIdSportif(String idSportif) {
    	
    	List<Bson> pipeline = new ArrayList<>();
    	
    	Bson match = Aggregates.match(Filters.eq("idSportif", Integer.parseInt(idSportif)));
        pipeline.add(match);
       
        Bson sportif = sportifsCollection.aggregate(pipeline).first();
        Sportifs sportifMapped = new Sportifs();
        
        sportifMapped = SportifDocumentMapper.mapToSportif(sportif);
        System.out.println(sportif.toString() + "************ DAO *************");
        
    	return sportifMapped;
    }
    
    
	public int addSportif(Map<String, Object> sportifBody) {
		System.out.println(sportifBody.toString() + "************ DAO *************");
		
		if ( sportifBody.containsKey("idSportif") && (sportifBody.get("idSportif") != null) ) {
			System.out.println("inside DAO>>idSportif if statement ");
			sportifBody.put("idSportif", Integer.parseInt((String) sportifBody.get("idSportif")));
		}
		
		if ( sportifBody.containsKey("age") && (sportifBody.get("age") != null) ) {
			System.out.println("inside DAO>>age if statement ");
			sportifBody.put("age", Integer.parseInt((String) sportifBody.get("age")));
		}
		
		if ( sportifBody.containsKey("idSportifConseiller") && (sportifBody.get("idSportifConseiller") != null) ) {
			System.out.println("inside DAO>>idSportifConseiller if statement ");
			sportifBody.put("idSportifConseiller", Integer.parseInt((String) sportifBody.get("idSportifConseiller")));
		}
		
		
    	try {
    		this.sportifsCollection.insertOne(new Document(sportifBody));

    	} catch (Exception e) {
    		System.out.println("##########  Couldn't add in dao");
    		return -1;
    	}
    	return 1;
    }

}
