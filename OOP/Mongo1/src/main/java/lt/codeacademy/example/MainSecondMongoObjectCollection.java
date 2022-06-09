package lt.codeacademy.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.Employer;

public class MainSecondMongoObjectCollection {
    public static void main(String[] args) {


        MongoClient client = MongoClientProvider.getObjectMongoClient();
        MongoDatabase database = client.getDatabase("myFirstMongoDb");

        MongoCollection<Employer> collection = database.getCollection("employers", Employer.class);

        FindIterable<Employer> employers = collection.find();

        for (Employer employer : employers) {
            System.out.println(employer);
        }

    }
}
