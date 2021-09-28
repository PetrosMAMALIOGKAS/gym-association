package com.simplon.gym.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

@Configuration
public abstract class AbstractGymDao {
	
	protected final String GYM_DATABASE;
	protected MongoDatabase db;
	protected MongoClient mongoClient;
	@Value("${spring.mongodb.uri}")
    private String connectionString;
	
	
	protected AbstractGymDao(MongoClient mongoClient, String databaseName) {
        this.mongoClient = mongoClient;
        GYM_DATABASE = databaseName;
        this.db = this.mongoClient.getDatabase(GYM_DATABASE);
    }
	
	public ObjectId generateObjectId() {
        return new ObjectId();
    }
	
//	 @SuppressWarnings("rawtypes")
//	public Map<String, Object> getConfiguration() {
//	        ConnectionString connString = new ConnectionString(connectionString);
//	        Bson command = new Document("connectionStatus", 1);
//	        Document connectionStatus = this.mongoClient.getDatabase(GYM_DATABASE).runCommand(command);
//
//	        List authUserRoles =
//	                ((Document) connectionStatus.get("authInfo")).get("authenticatedUserRoles", List.class);
//
//	        Map<String, Object> configuration = new HashMap<>();
//
//	        if (!authUserRoles.isEmpty()) {
//	            configuration.put("role", ((Document) authUserRoles.get(0)).getString(
//	                    "role"));
//	            configuration.put("pool_size", connString.getMaxConnectionPoolSize());
//	            configuration.put(
//	                    "wtimeout",
//	                    this.mongoClient
//	                            .getDatabase(GYM_DATABASE)
//	                            .getWriteConcern()
//	                            .getWTimeout(TimeUnit.MILLISECONDS));
//	        }
//	        return configuration;
//	    }
//	
}




