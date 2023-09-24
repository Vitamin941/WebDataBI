package ru.isu.math.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.isu.math.model.MyModel;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class ModelDAOImpl implements ModelDao {

    private final RowMapper<MyModel> myModelRowMapper = (resultSet, rowNum) -> {
        MyModel actor = new MyModel();
        actor.setId(resultSet.getInt("id"));
        actor.setText(resultSet.getString("text"));
        return actor;
    };

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
                "SELECT * FROM test WHERE id = ?",
                myModelRowMapper,
                id);
    }

    @Override
    public List<MyModel> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM test ORDER BY id ASC",
                myModelRowMapper);
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
