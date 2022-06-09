package lt.codeacademy.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.codeacademy.client.MongoClientProvider;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MainFirstMongoDelete {
    public static void main(String[] args) {

        MongoClient client  = MongoClientProvider.getMongoClient();
        MongoDatabase database = client.getDatabase("myFirstMongoDb");

        MongoCollection<Document> collection = database.getCollection("employers");

        //pagal object id
        collection.deleteOne(new Document("_id", new ObjectId("6296432d4dc1536099ba6bdc")));

        //pagal varda ir alga
        collection.deleteOne(Filters.and(Filters.eq("name", "Petras"),
                Filters.gt("salary", 180000)));

        FindIterable<Document> documents = collection.find();
        for(Document employer: documents) {
            System.out.println(employer);
        }
    }
}
