package lt.codeacademy.example;

import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class MainFirstMongoClient {
    public static void main(String[] args) {

        //1. create mongoDb client

        MongoClient client = new MongoClient();

        //2. Connect/switch to mongoDb

       MongoDatabase mongoDB =  client.getDatabase("myFirstMongoDb");

       //atvaizduoja pavadinima
       MongoIterable<String> collectionNames = mongoDB.listCollectionNames();

       for(String name: collectionNames) {
           System.out.println(name);
       }

       ListCollectionsIterable<Document> collections = mongoDB.listCollections();

       for(Document document : collections) {
           System.out.println(document);
           System.out.println(document.get("name"));
       }

    }
}
