package ru.alex.two.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.domain.User;
import ru.alex.two.repository.UserRepository;

import java.util.List;


@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/user/list")
    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
