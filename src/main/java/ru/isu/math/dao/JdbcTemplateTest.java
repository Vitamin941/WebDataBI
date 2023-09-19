package ru.isu.math.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcTemplateTest {

    public JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Autowired
    public JdbcTemplateTest(DataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    public void test() {
        String sqlInsert = "INSERT INTO test (id, text)"
                + " VALUES (?, ?)";
        jdbcTemplate.update(sqlInsert, 22, "aaaa@mail.com");
    }
}
