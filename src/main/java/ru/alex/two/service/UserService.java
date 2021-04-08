package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.two.domain.User;
import ru.alex.two.repository.UserRepository;

import java.util.List;

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
     *
     * @param user клиент для создания
     */

    public void creat(User user) {
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            logger.error(ex);
            logger.error("Ошибка, проверте введные данные клиента");
        }
    }

    /**
     * Возвращает список всех имеющихся клиентов
     *
     * @return список клиентов
     */

    public List<User> readAll() {
        return userRepository.findAll();
    }

    /**
     * Возвращает клиента по его ID
     *
     * @param id ID клиента
     * @return объект клиента с заданным ID
     */


    public User read(Long id) {
        try {
            return userRepository.getOne(id);
        } catch (Exception ex) {
            logger.error(ex);
            logger.error("Такого пользователя не существует, проверте введные" +
                    " " +
                    "данные");
        }
        return null;
    }

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     *
     * @param id   id клиента которого нужно обновить
     * @param user клиент в соответсвии с которым нужно обновить данные
     * @return true если данные были обновлены, иначе false
     */

    public Boolean update(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    /**
     * Удаляет клиента с заданным ID
     *
     * @param id id клиента, которого нужно удалить
     * @return true если клиент был удален, иначе false
     */

    public void delete(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            }
        } catch (Exception ex) {
            logger.error(ex);
        }
    }
}
