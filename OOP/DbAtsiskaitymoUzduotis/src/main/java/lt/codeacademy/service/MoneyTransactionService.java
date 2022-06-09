package lt.codeacademy.service;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.client.MongoClientProvider;
import lt.codeacademy.data.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MoneyTransactionService {

    private List<User> users;

    public void addUserToDb(User user) {
        MongoClient client = MongoClientProvider.getMongoClient();
        MongoDatabase database = client.getDatabase("MoneyTransactioService");
        MongoCollection<Document> collection = database.getCollection("users");

        Document document = new Document("name", user.getName()).append("surname", user.getSurname())
                .append("bankAccountBalance", user.getBankAccountBalance());

        collection.insertOne(document);
    }

    public void addUserToList() {
        MongoClient client = MongoClientProvider.getMongoClient();
        MongoDatabase database = client.getDatabase("MoneyTransactioService");

        MongoCollection<Document> collection = database.getCollection("users");

        users = new ArrayList<>();

        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            users.add(new User(document.getString("name"),
                    document.getString("surname"),
                    document.getInteger("bankAccountBalance")));
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
