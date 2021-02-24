package ru.alex.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.alex.two.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findAll(List<User> userList);
}
