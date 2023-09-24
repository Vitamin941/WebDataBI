package ru.isu.math.dao;

import java.util.List;
import ru.isu.math.model.MyModel;

public interface ModelDao {

    MyModel get(long id);

    List<MyModel> getAll();

//    boolean insert(Model model);
//
//    boolean delete(Model model);
//
//    boolean update(long id, Model model);
}
