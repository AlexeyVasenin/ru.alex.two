package ru.alex.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.two.domain.Types;

public interface TypesRepository  extends JpaRepository<Types, Long> {
}