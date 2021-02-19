package ru.alex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
