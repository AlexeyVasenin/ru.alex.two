package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.two.domain.Types;
import ru.alex.two.repository.TypesRepository;

import java.util.List;

@Service
public class TypesService {

    private final Logger logger = LogManager.getLogger(TypesService.class);

    private final TypesRepository typesRepository;

    @Autowired
    public TypesService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }


}
