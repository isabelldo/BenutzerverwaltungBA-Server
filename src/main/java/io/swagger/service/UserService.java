package io.swagger.service;
import io.swagger.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void createUser(User user) {
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
    }
    public void updateUser(User user) {

    }
    public void deleteUser(User user) {

    }
}