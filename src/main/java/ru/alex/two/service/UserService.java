package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.two.contollers.UserController;
import ru.alex.two.domain.User;
import ru.alex.two.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Создает нового клиента
     * *
     *
     * @return
     */
    public Object save(UserController.SaveUserReqt reqt) {
        User user = new User();
        Optional<User> numberUser =
                userRepository.findAll().stream().filter(u -> u.getNumber().equals(reqt.getNumber())).findFirst();
        if (!numberUser.isPresent()) {
            user.setName(reqt.getName());
            user.setNumber(reqt.getNumber());
            return update(user);
        } else return "Пользователь с таким номером уже существует";
    }

    /**
     * Обновляет клиента с заданным ID
     */
    public User update(User user) {
        return userRepository.save(user);
    }

    /**
     * Возвращает список всех имеющихся клиентов
     *
     * @return список клиентов
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Возвращает клиента по его ID
     *
     * @param id ID клиента
     * @return объект клиента с заданным ID
     */
    public User getOne(Long id) {
        try {
            return userRepository.findById(id).orElseGet(() -> null);
        } catch (Exception ex) {
            logger.error(ex);
            logger.error("Такого пользователя не существует, проверте введные" +
                    " " + "данные");
        }
        return null;
    }


    /**
     * Удаляет клиента с заданным ID
     *
     * @param id id клиента, которого нужно удалить
     * @return true если клиент был удален, иначе false
     */
    public long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
