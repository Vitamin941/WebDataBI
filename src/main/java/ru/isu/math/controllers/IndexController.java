package ru.isu.math.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.isu.math.dao.ModelDAOImpl;
import ru.isu.math.model.MyModel;

@Controller
public class IndexController {

    public final ModelDAOImpl modelDAOImpl;

    @Autowired
    IndexController(ModelDAOImpl modelDAOImpl) {
        this.modelDAOImpl = modelDAOImpl;
    }

    @GetMapping
    public String loadIndex() {
        MyModel testOne = modelDAOImpl.get(1);
        return "index";
    }

    @GetMapping("/table")
    public String loadTable() {
        return "";
    }
}
