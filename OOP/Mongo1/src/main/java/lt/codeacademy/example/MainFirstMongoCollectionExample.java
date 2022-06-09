package lt.codeacademy.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.codeacademy.client.MongoClientProvider;
import org.bson.Document;

import java.util.Iterator;

public class MainFirstMongoCollectionExample {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClientProvider.getMongoClient();

        MongoDatabase database = mongoClient.getDatabase("myFirstMongoDb");
        MongoCollection<Document> collection = database.getCollection("employers");

        //atsispausdinti reiksmes
        //FindIterable<Document> employers = collection.find();
        //su filtravimu, visos reiksmes daugiau 100000
        FindIterable<Document> employers = collection.find(Filters.gte("salary", 100000));
        for(Document employer : employers) {
            System.out.println(employer);
            System.out.printf("%s %s %s %s\n",employer.get("name"),employer.get("surname"), employer.get("job")
                    , employer.get("salary"));
        }

        //insert




        /* kitas budas atspausdinti
        Iterator<Document> iterator = collection.find().iterator();
        while (iterator.hasNext()) {
            Document employer = iterator.next();
            System.out.printf("%s %s %s %s\n",employer.get("name"),employer.get("surname"), employer.get("job")
                    , employer.get("salary"));
        }*/



    }
}
