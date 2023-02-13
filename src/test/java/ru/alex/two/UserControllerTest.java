package ru.alex.two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.alex.two.contollers.UserController;
import ru.alex.two.domain.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
  /*  @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Передача объекта без поля name возвращает код 400")
    void addTest() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post(
                "/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Alexey\",\"number\":\"79091159808\"}"))
                .andReturn();

        String message = requireNonNull(response.getResolvedException(), "Не получено сообщение от контроллера").getMessage();
        assertTrue(message.contains("default message [name]"));
        assertTrue(message.contains("default message [Необходимо указать " +
                "имя]"));
*/

}


  /*  @Test
    @DisplayName("Принудительная валидация находит ошибку")
    void manualValidationTest() {
        User user = new User(1L, "Alexey", "79091159802", null);
        Validator validator =
                Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        ConstraintViolation<User> violation =
                violations.stream().findFirst().orElseThrow(() -> new RuntimeException("Отсутствует ошибка валидации"));
        assertEquals("name", violation.getPropertyPath().toString());
        assertEquals("Необходимо указать имя", violation.getMessageTemplate());
    }*/


