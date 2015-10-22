package org.ihsp.data.dao.base;
import java.io.Serializable;
import java.util.List;
/**
 * 针对单个Entity对象的CRUD操作定义.
 */
public interface EntityDao<T,PK extends Serializable> {
    T getByID(PK id);
    T load(PK id);
    List<T> getAll();
    void save(T entity);
    void remove(T entity);
    void removeById(PK id);
    
    void update(T entity);
    /**
     * 获取Entity对象的主键名.
     */
    String getIdName(Class<T> clazz);
    
    public List<T> findBy(List<String> propertyNames, List<Object> values);

}