package lt.codeacademy.example;


import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.Employer;
import org.bson.Document;

public class MainSecondMongoClient {
    public static void main(String[] args) {

        MongoClient client  = MongoClientProvider.getObjectMongoClient();
        MongoDatabase database = client.getDatabase("myaSecondtMongoDb");
        MongoCollection<Employer> collection = database.getCollection("employers", Employer.class);

        MainSecondMongoClient main = new MainSecondMongoClient();

        FindIterable<Employer> employers = collection.find();
        main.printEmployers(employers);

        employers = collection.find(Filters.gt("salary", 100000));
        main.printEmployers(employers);

        employers = collection.find().sort(new BasicDBObject("salary", 1));
        main.printEmployers(employers);

        employers = collection.find(Filters.not(Filters.gt("salary", 1000000)));
        main.printEmployers(employers);
    }

    private void printEmployers(FindIterable<Employer> employers) {
        for (Employer employer : employers) {
            System.out.println(employer);
        }

        System.out.println("------------------------------------");
    }
}
