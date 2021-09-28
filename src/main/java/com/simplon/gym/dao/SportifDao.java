package com.simplon.gym.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;


@Repository
public class SportifDao extends AbstractGymDao{
	
	public static String SPORTIF_COLLECTION = "Sportifs";

    private MongoCollection<Document> sportifsCollection;
    
    
    @Autowired
    public SportifDao( MongoClient mongoClient, @Value("${spring.mongodb.database}") String databaseName) {
        super(mongoClient, databaseName);
        sportifsCollection = db.getCollection(SPORTIF_COLLECTION);
    }
    
    public List<Document> getAllSportifs() {
        
        List<Document> sportifs = new ArrayList<>();

        sportifsCollection
                .find()
                .iterator()
                .forEachRemaining(sportifs::add);

        return sportifs;
    }

}
