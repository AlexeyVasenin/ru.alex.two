package ru.alex.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.two.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {


}