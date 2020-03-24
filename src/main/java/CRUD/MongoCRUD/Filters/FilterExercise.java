package CRUD.MongoCRUD.Filters;

import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class FilterExercise {

	public static void main(String[] args) {

		// Creating a Mongo client 
		MongoClient mongo = new MongoClient( "localhost" , 27017 ); 

		//Accessing the database 
		MongoDatabase database = mongo.getDatabase("studentDatabase");  

		//Creating a collection 
		//				database.createCollection("studentCollection"); 
		//				System.out.println("Collection created successfully");

		// Retieving a collection
		MongoCollection<Document> collection = database.getCollection("studentCollection"); 
		System.out.println("Collection selected successfully"); 

		// 		FindIterable<Document> iterDoc = collection.find();



		// FindIterable<Document> iterDoc = collection.find(Filters.eq("Id", 101)); // Document{{_id=5e7a600b2ede2d0e9667f46b, title=StudentCollectionEntry, Id=101, Name=AAnA, Roll=1, Sec=B, Address=ABC road}}



		// FindIterable<Document> iterDoc = collection.find(Filters.ne("Id", 101)); // Returns whole document except the document WITH ID = 101



		// FindIterable<Document> iterDoc = collection.find(Filters.gt("Id", 112));


		/*
		 *	Document{{_id=5e7a600b2ede2d0e9667f477, title=StudentCollectionEntry, Id=113, Name=AAfgfgfgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f478, title=StudentCollectionEntry, Id=114, Name=AAfgfgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f479, title=StudentCollectionEntry, Id=115, Name=AAAfgfg, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f47a, title=StudentCollectionEntry, Id=116, Name=AAAhfnm, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f47b, title=StudentCollectionEntry, Id=117, Name=AAAnbn, Roll=1, Sec=B, Address=ABC road}}
		 * */



		// FindIterable<Document> iterDoc = collection.find(Filters.lt("Id", 15));


		/*
		 *  Document{{_id=5e7a600b2ede2d0e9667f45c, title=StudentCollectionEntry, Id=1, Name=AAA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45d, title=StudentCollectionEntry, Id=11, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45e, title=StudentCollectionEntry, Id=12, Name=AAfA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45f, title=StudentCollectionEntry, Id=13, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f460, title=StudentCollectionEntry, Id=14, Name=AAdA, Roll=1, Sec=B, Address=ABC road}}
		 * */



		// FindIterable<Document> iterDoc = collection.find(Filters.gte("Id", 15)); // Returns DOCUMENTS from ID =15 to ALL



		// FindIterable<Document> iterDoc = collection.find(Filters.lte("Id", 15)); // Returns all DOCUMENTS with ID<=15



		// FindIterable<Document> iterDoc = collection.find(Filters.in("Id", 11,15,25)); // This example creates a filter that selects all documents where the value of the Id field is EITHER 11 or 15 or25:
		/*
		 *  Document{{_id=5e7a600b2ede2d0e9667f45d, title=StudentCollectionEntry, Id=11, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f461, title=StudentCollectionEntry, Id=15, Name=AAsA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f46a, title=StudentCollectionEntry, Id=25, Name=AAiuiA, Roll=1, Sec=B, Address=ABC road}}
		 * */



		// FindIterable<Document> iterDoc = collection.find(Filters.nin("Id", 11,15,25)); // This example creates a filter that selects all documents where the value of the Id field is NEITHER 11 or 15 or25:



		// FindIterable<Document> iterDoc = collection.find(Filters.and(Filters.gt("Id", 11), Filters.lt("Id", 15))); // Finds the value where Id is greater than 11 and less than 15
		/*
		 * Document{{_id=5e7a600b2ede2d0e9667f45e, title=StudentCollectionEntry, Id=12, Name=AAfA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45f, title=StudentCollectionEntry, Id=13, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f460, title=StudentCollectionEntry, Id=14, Name=AAdA, Roll=1, Sec=B, Address=ABC road}}
		 * */



		// FindIterable<Document> iterDoc = collection.find(Filters.or(Filters.gt("Id", 1100), Filters.lt("Id", 15))); // As Id=1100 does not exists; it found all Documents where Id<15 
		/*
		 * Document{{_id=5e7a600b2ede2d0e9667f45c, title=StudentCollectionEntry, Id=1, Name=AAA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45d, title=StudentCollectionEntry, Id=11, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45e, title=StudentCollectionEntry, Id=12, Name=AAfA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45f, title=StudentCollectionEntry, Id=13, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f460, title=StudentCollectionEntry, Id=14, Name=AAdA, Roll=1, Sec=B, Address=ABC road}}
		 * */



		// FindIterable<Document> iterDoc = collection.find(Filters.not(Filters.eq("Id", 1))); // Returns all Documents EXCEPT the Document where Id=1



		// FindIterable<Document> iterDoc = collection.find(Filters.nor(Filters.eq("Id", 1), Filters.eq("Id", 12), Filters.eq("Id", 13), Filters.eq("Id", 14))); // Returns all except Id = 1, 12, 13, 14



		// FindIterable<Document> iterDoc = collection.find(Filters.exists("Address")); // Returns all the DOCUMENTS that has the field "Address"



		// FindIterable<Document> iterDoc = collection.find(Filters.exists("Cat", true)); // Returned the document that has only the FIELD "Cat"
		/*Document{{_id=5e7a600b2ede2d0e9667f45c, title=StudentCollectionEntry, Id=1, Name=AAA, Roll=1, Sec=B, Address=ABC road, Cat=Cat has pussy}}*/



		// FindIterable<Document> iterDoc = collection.find(Filters.mod("Id", 5,2)); // Creates a filter that matches all documents where the value of a field divided by a divisor has the specified remainder (i.e. perform a modulo operation to select documents).
		/*
		 * Document{{_id=5e7a600b2ede2d0e9667f45e, title=StudentCollectionEntry, Id=12, Name=AAfA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f463, title=StudentCollectionEntry, Id=17, Name=AAvvA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f46c, title=StudentCollectionEntry, Id=102, Name=AAmA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f471, title=StudentCollectionEntry, Id=107, Name=AAfgfgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f476, title=StudentCollectionEntry, Id=112, Name=AAgfgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f47b, title=StudentCollectionEntry, Id=117, Name=AAAnbn, Roll=1, Sec=B, Address=ABC road}}
		 * */



		// FindIterable<Document> iterDoc = collection.find(Filters.regex("Name", "AgA")); // Creates a filter that matches all documents where the value of the field matches the given regular expression pattern with the given options applied.
		/*
		 * Document{{_id=5e7a600b2ede2d0e9667f45d, title=StudentCollectionEntry, Id=11, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
			Document{{_id=5e7a600b2ede2d0e9667f45f, title=StudentCollectionEntry, Id=13, Name=AAgA, Roll=1, Sec=B, Address=ABC road}}
		 * */



		// 		FindIterable<Document> iterDoc = collection.find(Filters.text("Address")); // ERROR



		// FindIterable<Document> iterDoc = collection.find(Filters.where("function() { return ((this.Id) == \"1\") }")); // Pass JS function
		/*Document{{_id=5e7a600b2ede2d0e9667f45c, title=StudentCollectionEntry, Id=1, Name=AAA, Roll=1, Sec=B, Address=ABC road, Cat=Cat has pussy}}*/




		// FindIterable<Document> iterDoc = collection.find(Filters.all("tags", "blank","red")); // Creates a filter that matches all documents where the value of a field is an array that contains all the specified values.
		// both values should be matched
		/*Document{{_id=5e7a600b2ede2d0e9667f45c, title=StudentCollectionEntry, Id=1, Name=AAA, Roll=1, Sec=B, Address=ABC road, Cat=Cat has pussy, tags=[blank, red]}}*/



		// Creates a filter that matches all documents containing a field that is an array where at least one member of the array matches the given filter.
		Bson projection = Projections.fields(Projections.excludeId(), Projections.include("Id"), Filters.elemMatch("statusLog", Filters.eq("status", "Submitted"))); // Add Projections
		//FindIterable<Document> iterDoc = collection.find().projection(projection);
		// Id=101 had the status=submitted so MongoDB projected all Ids except ID=101
		/*
		 *  Document{{Id=1}}
			Document{{Id=11}}
			Document{{Id=12}}
			Document{{Id=13}}
			Document{{Id=14}}
			Document{{Id=15}}
			Document{{Id=16}}
			Document{{Id=17}}
			Document{{Id=18}}
			Document{{Id=19}}
			Document{{Id=21}}
			Document{{Id=21}}
			Document{{Id=23}}
			Document{{Id=24}}
			Document{{Id=25}}
			Document{{Id=101}}
			Document{{Id=102}}
			Document{{Id=103}}
			Document{{Id=104}}
			Document{{Id=105}}
			Document{{Id=106}}
			Document{{Id=107}}
			Document{{Id=108}}
			Document{{Id=109}}
			Document{{Id=110}}
			Document{{Id=111}}
			Document{{Id=112}}
			Document{{Id=113}}
			Document{{Id=114}}
			Document{{Id=115}}
			Document{{Id=116}}
			Document{{Id=117}}
		 * */


		
		FindIterable<Document> iterDoc = collection.find(Filters.size("tags", 2)); // Creates a filter that matches all documents where the value of a field is an array of the specified size.
		/*Document{{_id=5e7a600b2ede2d0e9667f45c, title=StudentCollectionEntry, Id=1, Name=AAA, Roll=1, Sec=B, Address=ABC road, Cat=Cat has pussy, tags=[blank, red]}}*/
		
		

		int i = 1; 

		// Getting the iterator 
		Iterator it = iterDoc.iterator(); 

		while (it.hasNext()) {  
			System.out.println(it.next());  
			i++; 
		}
	}

}
