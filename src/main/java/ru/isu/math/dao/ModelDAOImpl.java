package ru.isu.math.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.isu.math.model.MyModel;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class ModelDAOImpl implements ModelDao {

    public JdbcTemplate jdbcTemplate;

    public ModelDAOImpl() {}

    @Autowired
    public ModelDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    @Override
    public MyModel get(long id) {
        return jdbcTemplate.queryForObject(
                "select * from test where id = ?",
                (resultSet, rowNum) -> {
                    MyModel newMyModel = new MyModel();
                    newMyModel.setText(resultSet.getString("text"));
                    return newMyModel;
                },
                id);
    }

    @Override
    public List<MyModel> getAll() {
        return jdbcTemplate.query(
                "select * from test",
                ((resultSet, rowNum) -> {
                    MyModel newMyModel = new MyModel();
                    newMyModel.setText(resultSet.getString("text"));
                    return newMyModel;
                })
        );
    }

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
