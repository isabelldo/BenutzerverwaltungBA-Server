package io.swagger.service;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final MongoCollection<Document> userCollection;
    @Autowired
    public UserService(MongoCollection<Document> userCollection) {
        this.userCollection = userCollection;
    }

    //gets all users from database as document
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        FindIterable<Document> userDocuments = userCollection.find();
        for (Document userDocument : userDocuments) {
            User user = convertDocumentToUser(userDocument);
            users.add(user);
        }
        return users;
    }

    public Document createUser(User user) {
        User newUser = new User();

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
           throw new IllegalArgumentException("Please enter an username");
        }
        else if (user.getEmail() == null || user.getEmail().isEmpty())  {
           throw new IllegalArgumentException("Please enter your E-Mail-Adress");
        }
        else if (user.getFullName() == null || user.getFullName().isEmpty()) {
           throw new IllegalArgumentException("Please enter your full name");
        }
        else if(user.getPassword() == null || user.getPassword().isEmpty()) {
           throw new IllegalArgumentException("Please enter a password");
        }
        else {
            newUser.setUsername(user.getUsername());
            newUser.setEmail(user.getEmail());
            newUser.setFullName(user.getFullName());
            newUser.setPassword(user.getPassword());
        }

        return convertUserToDocument(newUser);
    }
    public void updateUser(User user) {

    }
    public void deleteUser(User user) {

    }

    //changes document to users-object
    private User convertDocumentToUser(Document userDocument) {
        User user = new User();

        user.setId(userDocument.getInteger("id"));
        user.setFullName(userDocument.getString("fullName"));
        user.setUsername(userDocument.getString("username"));
        user.setEmail(userDocument.getString("email"));
        user.setPassword(userDocument.getString("password"));
        user.setRole(userDocument.getString("role"));

        return user;
    }

    //changes users-object to document
    public Document convertUserToDocument(User user) {
        Document userDocument = new Document();

        userDocument.append("id", user.getId());
        userDocument.append("fullName", user.getFullName());
        userDocument.append("username", user.getUsername());
        userDocument.append("email", user.getEmail());
        userDocument.append("password", user.getPassword());
        userDocument.append("role", user.getRole());

        return userDocument;
    }
}