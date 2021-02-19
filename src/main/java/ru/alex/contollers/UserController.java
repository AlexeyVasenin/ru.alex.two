package ru.alex.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.domain.User;
import ru.alex.repository.UserRepository;

import java.util.List;


@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/user/all")
    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
