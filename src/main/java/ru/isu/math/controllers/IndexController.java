package ru.isu.math.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.isu.math.dao.ModelDAOImpl;
import ru.isu.math.model.Model;

@RestController
public class IndexController {

    public final ModelDAOImpl modelDAOImpl;

    @Autowired
    IndexController(ModelDAOImpl modelDAOImpl) {
        this.modelDAOImpl = modelDAOImpl;
    }

    @GetMapping
    public String loadIndex() {
        Model testOne = modelDAOImpl.get(1);
        return testOne.toString();
    }
}
