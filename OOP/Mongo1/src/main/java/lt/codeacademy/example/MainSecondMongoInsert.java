package lt.codeacademy.example;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.Employer;

import java.util.List;

public class MainSecondMongoInsert {
    public static void main(String[] args) {

        MongoClient client = MongoClientProvider.getObjectMongoClient();
        MongoDatabase database = client.getDatabase("mySecondMongoDB");

        MongoCollection<Employer> collection = database.getCollection("employers", Employer.class);

        collection.insertMany(List.of(new Employer(null, "Andrius", "Baltrunas", "developer", 99900.0, null),
                new Employer(null, "Petras", "Baltrunas", "developer", 99900.0, null),
                new Employer(null, "Jonas", "Baltrunas", "developer", 99900.0, null),
                new Employer(null, "Jokubas", "Baltrunas", "developer", 99900.0, null)));


        FindIterable<Employer> employers = collection.find();

        for(Employer employer : employers) {
            System.out.println(employer);
        }
    }
}
