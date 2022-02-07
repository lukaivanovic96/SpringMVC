package springmvc.services;

import java.util.List;

public interface CRUDService<T> {
    List<?> all();
    T getById(Integer id);
    T saveOrUpdate(T product);
    void delete(Integer id);
}
