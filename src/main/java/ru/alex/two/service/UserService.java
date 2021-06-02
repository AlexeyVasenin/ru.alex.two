package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alex.two.contollers.UserController;
import ru.alex.two.domain.User;
import ru.alex.two.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Создает нового клиента
     *
     */
    public User save(UserController.SaveUserReqt reqt) {
        User user = new User();
        user.setName(reqt.getName());
        user.setNumber(reqt.getNumber());
        user.setIdd(user.getIdd() + 1);
        return update(user);
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

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        User user = userRepository.findByNumber(number);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

}
