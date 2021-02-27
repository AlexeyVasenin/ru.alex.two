package ru.alex.two.service;

import org.springframework.stereotype.Service;
import ru.alex.two.domain.User;
import ru.alex.two.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void creat(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Boolean update(User user, int id) {
        if (userRepository.existsById((long) id)) {
            user.setId((long) id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        if (userRepository.existsById((long) id)){
            userRepository.deleteById((long) id);
            return true;
        }
        return false;
    }
}
