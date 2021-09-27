package dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import model.Sportif;

public class SportifDao extends AbstractGymDao{
	
	public static String SPORTIF_COLLECTION = "sportifs";

    private MongoCollection<Document> sportifsCollection;
    
    
    @Autowired
    public SportifDao( MongoClient mongoClient, @Value("${spring.mongodb.database}") String databaseName) {
        super(mongoClient, databaseName);
        sportifsCollection = db.getCollection(SPORTIF_COLLECTION);
    }
    
    @SuppressWarnings("UnnecessaryLocalVariable")
    public List<Document> getAllSportifs() {
        
        List<Document> sportifs = new ArrayList<>();

        sportifsCollection
                .find()
                .iterator()
                .forEachRemaining(sportifs::add);

        return sportifs;
    }

}
