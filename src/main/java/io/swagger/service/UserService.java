package io.swagger.service;
import io.swagger.repository.UserRepository;
import io.swagger.model.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public abstract class UserService implements UserRepository {
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserService(UserRepository userRepository, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    //gets all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    //gets one user by id
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    @Override
    public <specificUser extends User> specificUser save(specificUser user) {
        return mongoTemplate.save(user);
    }

    @Override
    //deletes user by id
    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public void updateEmail(ObjectId id, String email) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("email", email);

        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updatePassword(ObjectId id, String password) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("password", password);

        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateRole(ObjectId id, String role) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("role", role);

        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateFullName(ObjectId id, String fullName) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("fullName", fullName);

        mongoTemplate.updateFirst(query, update, User.class);
    }
}