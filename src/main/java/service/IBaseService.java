package service;

import java.sql.SQLException;
import java.util.List;

public interface IBaseService<T> {
    List<T> showAll() throws SQLException;

    void insert(T data) throws SQLException;

    void update(T data, int id) throws SQLException;

    void delete(int id);

    T findByID(int id) throws SQLException;
}
