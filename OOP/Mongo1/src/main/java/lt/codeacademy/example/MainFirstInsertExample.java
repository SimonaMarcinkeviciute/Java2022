package lt.codeacademy.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import org.bson.Document;

import java.util.List;

public class MainFirstInsertExample {
    public static void main(String[] args) {

        //insert viena karta

        MongoClient client  = MongoClientProvider.getMongoClient();
        MongoDatabase database = client.getDatabase("myFirstMongoDb");

        MongoCollection<Document> collection = database.getCollection("employers");

        Document document = new Document("name", "TestUser").append("surname", "SimpleUser").append("job", "test")
                .append("salary", 50000);

        collection.insertOne(document);
        //insert daug
        //collection.insertMany(List.of(new Document(....), new Document(......)));


    }
}
