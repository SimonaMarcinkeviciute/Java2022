package lt.codeacademy.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lt.codeacademy.client.MongoClientProvider;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MainFirstMongoUpdate {
    public static void main(String[] args) {

        MongoClient client  = MongoClientProvider.getMongoClient();
        MongoDatabase database = client.getDatabase("myFirstMongoDb");

        MongoCollection<Document> collection = database.getCollection("employers");

        MainFirstMongoUpdate main = new MainFirstMongoUpdate();
        main.printCollection(collection);

        //updatinam

        collection.updateOne(Filters.eq("name", "TestUser"), Updates.set("name", "Juozukas"));
        collection.updateOne(Filters.and(Filters.eq("name", "Juozukas"), Filters.eq("surname", "SimpleUser")),
                Updates.set("surname", "Nauja Pavarde"));


        //ideti kelias reiksmes
        collection.updateOne(Filters.and(Filters.eq("name", "Juozukas"), Filters.eq("surname", "Nauja Pavarde")),
        Updates.combine(Updates.set("name", "Petriukas"), Updates.set("surname", "Vel kazkas")));

        System.out.println("-----------");

        main.printCollection(collection);

        //atnaujinti visa ojekta is karto

        Document document = new Document("name", "Naujas Petras")
                .append("surname", "Naujas Petraitis")
                .append("job", "Naujas Developer"). append("salary", 20000);

        collection.updateOne(Filters.eq("_id", new ObjectId("6294f80b35aa4101eb1b8122")),
                new Document("$set", document));


    }

    //metodas atspausdinti prie update
    private void printCollection(MongoCollection<Document> collection) {
        FindIterable<Document> documents = collection.find();

        for(Document employer: documents) {
            System.out.println(employer);
        }
    }
}
