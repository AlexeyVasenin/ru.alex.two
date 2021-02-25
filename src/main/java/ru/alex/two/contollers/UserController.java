package ru.alex.two.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.repository.UserRepository;
import ru.alex.two.service.UserService;


@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public ResponseEntity<?> creat() {
        userService.creat(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
