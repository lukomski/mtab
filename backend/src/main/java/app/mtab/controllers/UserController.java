package app.mtab.controllers;

import app.mtab.models.User;
import app.mtab.repositiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public String getName() {
        User meUser = new User("meUser");
        userRepository.save(meUser);
        return "dupa";
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
