package io.swagger.configuration;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {
    final String pathToKeystore = System.getenv("PATH_TO_PEM");
    final String keystorePassword = System.getenv("KEYSTORE_PASSWORD");
    final String connectionDB = System.getenv("DB_CONNECTION");
    final String nameDB = System.getenv("DB_NAME");
    final String collection = System.getenv("COLLECTION");

    @Bean //connecting with MongoDB Database
    public MongoClient mongoClient() {
        System.setProperty("javax.net.ssl.keyStore", pathToKeystore);
        System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);

        ConnectionString connectionString = new ConnectionString(connectionDB);
        return MongoClients.create(connectionString);
    }

    @Bean //gets Database
    public MongoDatabase mongoDatabase() {
        return mongoClient().getDatabase(nameDB);
    }

    @Bean //gets collection
    public MongoCollection<Document> mongoCollection() {
        return mongoDatabase().getCollection(collection);
    }
}
