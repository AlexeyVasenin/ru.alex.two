package ru.alex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.repos.MainRepo;

@Service
public class MainService {

    @Autowired
    MainRepo mainRepo;


}
