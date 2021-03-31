package ru.alex.two.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.User;
import ru.alex.two.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/cafe")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> readAll() {
        final List<User> users = userService.readAll();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> read(@PathVariable("id") Long id) {
        User user = userService.read(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @PostMapping("/user")
    public void registration(@RequestParam String name,
                             @RequestParam String number) {
        User user = new User(name, number);
        userService.creat(user);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id,
                                       @RequestBody User user) {
        Boolean updateUser = userService.update(id, user);
        if (updateUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}