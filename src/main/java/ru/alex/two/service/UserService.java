package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.alex.two.domain.User;
import ru.alex.two.repository.UserRepository;

import java.util.List;


@Service
public class UserService {

    Logger log = LogManager.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Создает нового клиента
     *
     * @param user - клиент для создания
     */

    public void creat(User user) {
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            log.error(ex);
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
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */


    public User read(Long id) {
        return userRepository.getOne(id);
    }

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     *
     * @param user - клиент в соответсвии с которым нужно обновить данные
     * @param id   - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */

    public Boolean update(User user, Long id) {
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
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */

    public Boolean delete(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return true;
            }

        } catch (Exception ex) {
            log.error(ex);
        }
        return false;
    }
}
