package ru.isu.math.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.isu.math.model.ArabData;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class ArabDataDAOImpl implements ArabDataDao {

    private final RowMapper<ArabData> myModelRowMapper = (resultSet, rowNum) -> {
        ArabData arabData = new ArabData();
        arabData.setId(resultSet.getInt("id"));
        arabData.setRegion(resultSet.getString("region"));
        arabData.setYear(resultSet.getInt("year"));
        arabData.setGender(resultSet.getString("gender"));
        arabData.setNationaly(resultSet.getString("nationaly"));
        arabData.setPopulation(resultSet.getInt("population"));
        return arabData;
    };

    public JdbcTemplate jdbcTemplate;

    public ArabDataDAOImpl() {}

    @Autowired
    public ArabDataDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    @Override
    public ArabData get(long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Arabia_population WHERE id = ?",
                myModelRowMapper,
                id);
    }

    @Override
    public List<ArabData> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Arabia_population ORDER BY id ASC",
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
