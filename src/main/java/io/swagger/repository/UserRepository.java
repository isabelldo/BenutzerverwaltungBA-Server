package io.swagger.repository;
import io.swagger.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    //gets all users
    List<User> findAll();

    //gets a user by id
    Optional<User> findById(ObjectId id);

    //deletes one user
    void deleteById(ObjectId id);

    //saves user
    <specificUser extends User> specificUser save(specificUser user);
}
