package ru.isu.math.dao;

import java.util.List;
import ru.isu.math.model.ArabData;

public interface ArabDataDao {

    ArabData get(long id);

    List<ArabData> getAll();

//    boolean insert(Model model);
//
//    boolean delete(Model model);
//
//    boolean update(long id, Model model);
}
