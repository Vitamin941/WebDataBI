package ru.isu.math.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.isu.math.repositories.ModelTestRepository;

@Controller
public class IndexController {

    public ModelTestRepository testRepository;

    @Autowired
    IndexController(ModelTestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping
    public String loadIndex() {
        long count = testRepository.count();
        return "index";
    }
}
