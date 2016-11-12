package dao;

import java.util.ArrayList;
import java.util.List;

public class AbstractDAOImpl<T> implements AbstractDAO<T> {
    private List<T> list = new ArrayList<T>();

    @Override
    public T save(T t) {
        list.add(t);
        return t;
    }

    @Override
    public T delete(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T findById(long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return list;
    }

}
