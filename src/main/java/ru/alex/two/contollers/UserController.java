package ru.alex.two.contollers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.User;
import ru.alex.two.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Запросить всех зарегистрированых пользователей")
    @GetMapping()
    public ResponseEntity<List<User>> readAll() {
        final List<User> users = userService.readAll();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "ЗАпрос пользователя по Id")
    @GetMapping("/user/{id}")
    public ResponseEntity<User> read(@PathVariable("id") Long id) {
        User user = userService.read(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Регистрация нового пользователя")
    @PostMapping("/add")
    public void registration(@RequestParam("name") String name,
                             @RequestParam("number") String number) {
        User user = new User(name, number);
        userService.creat(user);
    }

    @ApiOperation(value = "Обновление данных пользователя")
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id,
                                       @RequestBody User user) {
        Boolean updateUser = userService.update(id, user);
        if (updateUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @ApiOperation(value = "Удалить пользователя")
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}