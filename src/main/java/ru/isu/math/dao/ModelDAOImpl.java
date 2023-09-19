package ru.isu.math.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.isu.math.model.Model;
import javax.sql.DataSource;

@Repository
public class ModelDAOImpl implements ModelDao {

    public JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Autowired
    public ModelDAOImpl(DataSource dataSource) {
        jdbcTemplate.setDataSource(dataSource);
    }

    @Override
    public Model get(long id) {
        Model model = jdbcTemplate.queryForObject(
                "select * from test where id = ?",
                (resultSet, rowNum) -> {
                    Model newModel = new Model();
                    newModel.setText(resultSet.getString("text"));
                    return newModel;
                },
                id);
        return model;
    }

//    @Override
//    public List<Model> getAll() {
//        return null;
//    }

//    @Override
//    public boolean insert(Model model) {
//        String sqlInsert = "INSERT INTO test (id, text)"
//                + " VALUES (?, ?)";
//        jdbcTemplate.update(sqlInsert, 22, "aaaa@mail.com");
//        return true;
//    }
//
//    @Override
//    public boolean delete(Model model) {
//        return false;
//    }
//
//    @Override
//    public boolean update(long id, Model model) {
//        return false;
//    }
}
