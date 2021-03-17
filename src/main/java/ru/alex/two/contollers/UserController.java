package ru.alex.two.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.User;
import ru.alex.two.service.UserService;

import javax.websocket.server.PathParam;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "/registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String name,
                               @RequestParam String number) {
        User user = new User(name, number);
        userService.creat(user);

        return "redirect:/login";
    }

    @GetMapping("/user/list")
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

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@RequestBody User user,
                                       @PathVariable("id") Long id) {
        Boolean updateUser = userService.update(user, id);
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