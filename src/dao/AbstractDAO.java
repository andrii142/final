package dao;

import java.util.List;

public interface AbstractDAO<T> {
    T save(T t);

    T delete(T t);

    T update(T t);

    T findById(long id);

    List<T> getAll();
}
