package io.swagger.service;
import io.swagger.model.UserModel;
import io.swagger.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class UserService implements UserRepository {
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public void updateEmail(String id, String email) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("email", email);

        mongoTemplate.updateFirst(query, update, UserModel.class);
    }

    public void updatePassword(String id, String password) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("password", password);

        mongoTemplate.updateFirst(query, update, UserModel.class);
    }

    public void updateRole(String id, String role) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("role", role);

        mongoTemplate.updateFirst(query, update, UserModel.class);
    }

    public void updateFullName(String id, String fullName) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("fullName", fullName);

        mongoTemplate.updateFirst(query, update, UserModel.class);
    }



    @Override
    public <S extends UserModel> S insert(S entity) {
        return userRepository.insert(entity);
    }

    @Override
    public <S extends UserModel> List<S> insert(Iterable<S> entities) {
        return userRepository.insert(entities);
    }

    @Override
    public <S extends UserModel> Optional<S> findOne(Example<S> example) {
        return userRepository.findOne(example);
    }

    @Override
    public <S extends UserModel> List<S> findAll(Example<S> example) {
        return findAll(example);
    }

    @Override
    public <S extends UserModel> List<S> findAll(Example<S> example, Sort sort) {
        return userRepository.findAll(example, sort);
    }

    @Override
    public <S extends UserModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return userRepository.findAll(example, pageable);
    }

    @Override
    public <S extends UserModel> long count(Example<S> example) {
        return userRepository.count(example);
    }

    @Override
    public <S extends UserModel> boolean exists(Example<S> example) {
        return userRepository.exists(example);
    }

    @Override
    public <S extends UserModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return userRepository.findBy(example, queryFunction);
    }

    @Override
    public <S extends UserModel> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public <S extends UserModel> List<S> saveAll(Iterable<S> entities) {
        return userRepository.saveAll(entities);
    }

    @Override
    public Optional<UserModel> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserModel> findAllById(Iterable<String> id) {
        return userRepository.findAllById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(UserModel entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> id) {
        userRepository.deleteAllById(id);
    }

    @Override
    public void deleteAll(Iterable<? extends UserModel> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<UserModel> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}