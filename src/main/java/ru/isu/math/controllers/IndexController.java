package ru.isu.math.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.isu.math.dao.ArabDataDAOImpl;
import ru.isu.math.model.ArabData;
import java.util.List;

@Controller
public class IndexController {

    public final ArabDataDAOImpl modelDAOImpl;

    @Autowired
    IndexController(ArabDataDAOImpl modelDAOImpl) {
        this.modelDAOImpl = modelDAOImpl;
    }

    @GetMapping("/")
    public String loadIndex() {
        return "index";
    }

    @GetMapping("/table")
    public String loadTable(Model model) {
        List<ArabData> models = modelDAOImpl.getAll();
        model.addAttribute("data",models);
        return "table";
    }
}
