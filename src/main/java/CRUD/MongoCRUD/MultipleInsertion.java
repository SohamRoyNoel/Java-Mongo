package CRUD.MongoCRUD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import CRUD.MongoCRUD.pojo.ListProvider;
import CRUD.MongoCRUD.pojo.StudentsModel;

public class MultipleInsertion {

	public static void main(String[] args) {


		// Creating a Mongo client 
		MongoClient mongo = new MongoClient( "localhost" , 27017 ); 

		//Accessing the database 
		MongoDatabase database = mongo.getDatabase("studentDatabase");  

		//Creating a collection 
		database.createCollection("studentCollection"); 
		System.out.println("Collection created successfully");

		// Retieving a collection
		MongoCollection<Document> collection = database.getCollection("studentCollection"); 
		System.out.println("Collection myCollection selected successfully"); 
		
		// Receive the predefined list
		List<StudentsModel> getList = ListProvider.getListValue();
		// Create a list of documents
		List<Document> mongoDocument = new ArrayList<Document>();
		
		for (StudentsModel sm : getList) {
			Document document = new Document("title", "StudentCollectionEntry") 
					.append("Id", sm.getId())
					.append("Name", sm.getName()) 
					.append("Roll", sm.getRoll()) 
					.append("Sec", sm.getSec()) 
					.append("Address", sm.getAddress()); 
			mongoDocument.add(document);
		}
		
		collection.insertMany(mongoDocument);
		
		// Retrive
		FindIterable<Document> iterDoc = collection.find(); 
		int i = 1; 

		// Getting the iterator 
		Iterator it = iterDoc.iterator(); 

		while (it.hasNext()) {  
			System.out.println(it.next());  
			i++; 
		}

	}

}
/*
 * Collection created successfully
Collection myCollection selected successfully
Document{{_id=5e7a58e9e40ffb353c98b54c, title=StudentCollectionEntry, Id=1, Name=AAA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b54d, title=StudentCollectionEntry, Id=11, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b54e, title=StudentCollectionEntry, Id=12, Name=AAfA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b54f, title=StudentCollectionEntry, Id=13, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b550, title=StudentCollectionEntry, Id=14, Name=AAdA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b551, title=StudentCollectionEntry, Id=15, Name=AAsA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b552, title=StudentCollectionEntry, Id=16, Name=AAfA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b553, title=StudentCollectionEntry, Id=17, Name=AAvvA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b554, title=StudentCollectionEntry, Id=18, Name=AAvcvA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b555, title=StudentCollectionEntry, Id=19, Name=AAcA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b556, title=StudentCollectionEntry, Id=21, Name=AAoA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b557, title=StudentCollectionEntry, Id=21, Name=AAcxA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b558, title=StudentCollectionEntry, Id=23, Name=AAhA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b559, title=StudentCollectionEntry, Id=24, Name=AAhhA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b55a, title=StudentCollectionEntry, Id=25, Name=AAiuiA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b55b, title=StudentCollectionEntry, Id=101, Name=AAnA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b55c, title=StudentCollectionEntry, Id=102, Name=AAmA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b55d, title=StudentCollectionEntry, Id=103, Name=AAkkA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b55e, title=StudentCollectionEntry, Id=104, Name=AAkkA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b55f, title=StudentCollectionEntry, Id=105, Name=AAkkkA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b560, title=StudentCollectionEntry, Id=106, Name=AAhgkgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b561, title=StudentCollectionEntry, Id=107, Name=AAfgfgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b562, title=StudentCollectionEntry, Id=108, Name=AAAvxgh, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b563, title=StudentCollectionEntry, Id=109, Name=AAfghA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b564, title=StudentCollectionEntry, Id=110, Name=AAgfA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b565, title=StudentCollectionEntry, Id=111, Name=AAgfgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b566, title=StudentCollectionEntry, Id=112, Name=AAgfgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b567, title=StudentCollectionEntry, Id=113, Name=AAfgfgfgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b568, title=StudentCollectionEntry, Id=114, Name=AAfgfgA, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b569, title=StudentCollectionEntry, Id=115, Name=AAAfgfg, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b56a, title=StudentCollectionEntry, Id=116, Name=AAAhfnm, Roll=1, Sec=B, Address=ABC road}}
Document{{_id=5e7a58e9e40ffb353c98b56b, title=StudentCollectionEntry, Id=117, Name=AAAnbn, Roll=1, Sec=B, Address=ABC road}}
 * */
