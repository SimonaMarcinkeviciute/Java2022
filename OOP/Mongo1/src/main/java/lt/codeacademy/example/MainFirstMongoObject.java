package lt.codeacademy.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.Employer;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MainFirstMongoObject {
    public static void main(String[] args) {

        MongoClient client  = MongoClientProvider.getMongoClient();
        MongoDatabase database = client.getDatabase("myFirstMongoDb");

        MongoCollection<Document> collection = database.getCollection("employers");

        List<Employer> employers = new ArrayList<>();

        FindIterable<Document> documents = collection.find();
        for(Document document : documents) {
            employers.add(new Employer(document.getObjectId("_id"),
                    document.getString("name"),
                    document.getString("surname"),
                    document.getString("job"),
                    document.getDouble("salary"),
                    document.getString("description")));
        }

        employers.forEach(System.out::println);
    }
}
