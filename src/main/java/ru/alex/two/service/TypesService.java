package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.alex.two.repository.TypesRepository;

public class TypesService {

    Logger log = LogManager.getLogger(TypesService.class);

    private final TypesRepository typesRepository;

    public TypesService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }
}
