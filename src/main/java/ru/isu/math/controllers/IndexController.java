package ru.isu.math.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.isu.math.dao.JdbcTemplateTest;
import ru.isu.math.repositories.ModelTestRepository;

@Controller
public class IndexController {

//    public ModelTestRepository testRepository;

    public final JdbcTemplateTest jdbcTemplateTest;

    @Autowired
    IndexController(JdbcTemplateTest jdbcTemplateTest) {
//        this.testRepository = testRepository;
        this.jdbcTemplateTest = jdbcTemplateTest;
    }

    @GetMapping
    public String loadIndex() {
        jdbcTemplateTest.test();
        return "index";
    }
}
