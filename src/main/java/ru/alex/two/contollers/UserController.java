package ru.alex.two.contollers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.SimpleResult;
import ru.alex.two.domain.User;
import ru.alex.two.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Запросить всех зарегистрированых пользователей")
    @GetMapping("/users/all")
    @ResponseBody
    public SimpleResult<List<User>> getAll() {
        return new SimpleResult<>(userService.getAll());
    }

    @ApiOperation(value = "Запрос пользователя по Id")
    @GetMapping("/users/{id}")
    @ResponseBody
    public SimpleResult<User> getById(@PathVariable("id") String id) {
        return new SimpleResult<>(userService.getOne(Long.parseLong(id)));
    }

    @Getter
    @Setter
    public static class SaveUserReqt {
        private String name;

        @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, " +
                "затем " +
                "-" +
                " 10 цифр")
        private String number;
    }

    @ApiOperation(value = "Регистрация нового пользователя")
    @PostMapping("/users")
    @ResponseBody
    public SimpleResult<Object> add(@RequestBody @Valid SaveUserReqt reqt) {
        return new SimpleResult<>(userService.save(reqt));
    }

    @ApiOperation(value = "Обновление данных пользователя")
    @PutMapping("/users")
    @ResponseBody
    public SimpleResult<User> update(@RequestBody @Valid User user) {
        return new SimpleResult<>(userService.update(user));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class DeleteUserResp {
        private final long id;

    }

    @ApiOperation(value = "Удалить пользователя")
    @DeleteMapping("/users/del/{id}")
    @ResponseBody
    public SimpleResult<DeleteUserResp> delete(@PathVariable String id) {
        return new SimpleResult<>(new DeleteUserResp(userService.delete(Long.parseLong(id))));
    }
}