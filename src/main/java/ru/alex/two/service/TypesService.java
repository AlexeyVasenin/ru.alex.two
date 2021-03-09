package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.alex.two.domain.Types;
import ru.alex.two.repository.TypesRepository;

@Service
public class TypesService {

    Logger log = LogManager.getLogger(TypesService.class);

    private final TypesRepository typesRepository;

    public TypesService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }

    public void creat(Types types) {
        try {
            typesRepository.save(types);
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    public Boolean update(Types types, Long id) {
        if (typesRepository.existsById(id)) {
            types.setId(id);
            typesRepository.save(types);
            return true;
        }
        return false;
    }
}
