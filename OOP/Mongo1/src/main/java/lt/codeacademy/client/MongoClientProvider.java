package lt.codeacademy.client;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoClientProvider {

    public static MongoClient getMongoClient() {

        return  new MongoClient();
    }

    public static com.mongodb.client.MongoClient getObjectMongoClient() {
        //Uzregistruoti provider codec

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        //uzregistruoti pojo i provideri i registries
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        //codec registry idedame i settings
        MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(codecRegistry).build();

        return   MongoClients.create(settings);
    }
}
