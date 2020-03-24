package CRUD.MongoCRUD;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class CreateConnection {

	public static void main(String[] args) {

		// Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	      List<String> dbs = mongo.getDatabaseNames();
	      
	      System.out.println(dbs); // [JavaTestDatabase, admin, config, flights, local]
	   
//	      // Creating Credentials 
//	      MongoCredential credential; 
//	      credential = MongoCredential.createCredential("sampleUser", "myDb", 
//	         "password".toCharArray()); 
//	      System.out.println("Connected to the database successfully");  
//	      
//	      // Accessing the database 
//	      MongoDatabase database = mongo.getDatabase("JavaTestDatabase"); 
//	      System.out.println("Credentials ::"+ credential);  
		
	}

}
