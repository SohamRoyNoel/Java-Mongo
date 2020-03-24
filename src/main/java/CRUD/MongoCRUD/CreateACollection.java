package CRUD.MongoCRUD;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class CreateACollection {

	public static void main(String[] args) {

		// Creating a Mongo client 
		MongoClient mongo = new MongoClient( "localhost" , 27017 ); 

		//Accessing the database 
		MongoDatabase database = mongo.getDatabase("JavaTestDatabase");  

		//Creating a collection 
		/*database.createCollection("sampleCollection"); 
		System.out.println("Collection created successfully");*/

		// Retieving a collection
		MongoCollection<Document> collection = database.getCollection("sampleCollection"); 
		System.out.println("Collection myCollection selected successfully"); 

		// Insert Data
		Document document = new Document("title", "MongoDB") 
				.append("id", 1)
				.append("description", "database") 
				.append("likes", 100) 
				.append("url", "http://www.tutorialspoint.com/mongodb/") 
				.append("by", "tutorials point");  
		collection.insertOne(document); 
		System.out.println("Document inserted successfully");  

		// Retriving Data [MongoDB Query : db.sampleCollection.find()]
		// Getting the iterable object 
		// Read
		FindIterable<Document> iterDoc = collection.find(); 
		int i = 1; 

		// Getting the iterator 
		Iterator it = iterDoc.iterator(); 

		while (it.hasNext()) {  
			System.out.println(it.next());  
			i++; 
		}

		System.out.println("-------------------------------------------------------------------------------");
		// Update [ db.sampleCollection.update( {"id" :1}, {$set: {"id" : 2}}); ]
		collection.updateOne(Filters.eq("id", 1), Updates.set("likes", 150));       
		System.out.println("Document update successfully...");  

		// Retrieving the documents after updation 
		// Getting the iterable object
		FindIterable<Document> iterDocs = collection.find(); 
		int j = 1; 

		// Getting the iterator 
		Iterator its = iterDocs.iterator(); 

		while (its.hasNext()) {  
			System.out.println(its.next());  
			j++; 
		} 

		System.out.println("-------------------------------------------------------------------------------");
		// Delete [ db.sampleCollection.remove( { id:1 } ) ]
		// Deleting the documents 
		/*
		 collection.deleteOne(Filters.eq("id", 1)); 
		System.out.println("Document deleted successfully..."); 
		 */

		// Retrieving the documents after updation 
		// Getting the iterable object 
		FindIterable<Document> iterDocss = collection.find(); 
		int iss = 1; 

		// Getting the iterator 
		Iterator itss = iterDocss.iterator(); 

		while (itss.hasNext()) {  
			System.out.println("Inserted Document: "+i);  
			System.out.println(itss.next());  
			i++; 
		}

		System.out.println("-------------------------------------------------------------------------------");
		// Dropping a Collection [ db.sampleCollection.drop() ]
		/* collection.drop(); 
		System.out.println("Collection dropped successfully");*/
	}

}
