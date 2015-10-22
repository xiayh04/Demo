package org.ihsp.data.dao.base;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.ihsp.data.dao.base.impl.HibernateHQLDao;
import org.ihsp.data.dao.base.support.Page;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * 提供hibernate dao的所有操作,<br>
 * 实现类由spring注入HibernateEntityDao和HibernateGenericDao来实现
 * 
 */
public interface IBaseDao<T,PK extends Serializable> {
    
    /**
     * 获取全部对象
     * 
     * @see HibernateHQLDao#getAll(Class)
     */
    public List<T> getAll();
    
    /**
     * 获取全部对象,带排序参数.
     */
    public List<T> getAll(String orderBy, boolean isAsc);
    
    /**
     * 根据ID移除对象.
     */
    public void removeById(PK id);
    
    /**
     * 取得Entity的Criteria.
     */
    public Criteria createCriteria(Criterion... criterions);
    
    /**
     * 取得Entity的Criteria,带排序参数.
     */
    public Criteria createCriteria(String orderBy, boolean isAsc,
            Criterion... criterions);
    
    /**
     * 根据属性名和属性值查询对象.
     * 
     * @return 符合条件的对象列表
     */
    public List<T> findBy(String propertyName, Object value);
    
    /**
     * 根据属性名和属性值查询对象,带排序参数.
     * 
     * @return 符合条件的对象列表
     */
    public List<T> findBy(String propertyName, Object value, String orderBy,
            boolean isAsc);
    
    /**
     * 根据属性名和属性值查询单个对象.
     * 
     * @return 符合条件的唯一对象 or null
     */
    public T findUniqueBy(String propertyName, Object value);
    
    /**
     * 判断对象某些属性的值在数据库中唯一.
     * 
     * @param uniquePropertyNames
     *            在POJO里不能重复的属性列表,以逗号分割 如"name,loginid,password"
     * @see HibernateHQLDao#isUnique(Class,Object,String)
     */
    public boolean isUnique(T entity, String uniquePropertyNames);
    
    /**
     * 消除与 Hibernate Session 的关联
     * 
     */
    public void evit(T entity);
    
    
    /**
     * 根据ID获取对象. 实际调用Hibernate的session.load()方法返回实体或其proxy对象. 如果对象不存在，抛出异常.
     */
    public T getByID(PK id);
    
    public void saveOrUpdate(T o);
    /**
     * 保存对象.
     */
    public void save(T o);
    
    /**
     * 删除对象.
     */
    public void remove(T o);
    
    public void flush();
    
    public void clear();
    
    /**
     * 创建Query对象. 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
     * 留意可以连续设置,如下：
     * <pre>
     * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
     * </pre>
     * 调用方式如下：
     * <pre>
     *        dao.createQuery(hql)
     *        dao.createQuery(hql,arg0);
     *        dao.createQuery(hql,arg0,arg1);
     *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
     * </pre>
     *
     * @param values 可变参数.
     */
    public Query createQuery(String hql, Object... values);
    
    
    /**
     * 根据hql查询,直接使用HibernateTemplate的find函数.
     */
    @SuppressWarnings("unchecked")
    public List find(String hql, Object... values);
    
    /**
     * 分页查询函数，使用hql.
     *
     * @param pageNo 页号,从1开始.
     */
    public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values);
    
    /**
     * @param hql 查询sql
     * @param start 分页从哪一条数据开始
     * @param pageSize 每一个页面的大小
     * @param values 查询条件
     * @return page对象
     */
    public Page dataQuery(String hql, int start, int pageSize, Object... values);
    
    /**
     * 分页查询函数，使用已设好查询条件与排序的<code>Criteria</code>.
     *
     * @param pageNo 页号,从1开始.
     * @return 含总记录数和当前页数据的Page对象.
     */
    public Page pagedQuery(Criteria criteria, int pageNo, int pageSize);
    
    /**
     * 分页查询函数，根据entityClass和查询条件参数创建默认的<code>Criteria</code>.
     *
     * @param pageNo 页号,从1开始.
     * @return 含总记录数和当前页数据的Page对象.
     */
    public Page pagedQuery(int pageNo, int pageSize, Criterion... criterions);
    
    /**
     * 分页查询函数，根据entityClass和查询条件参数,排序参数创建默认的<code>Criteria</code>.
     *
     * @param pageNo 页号,从1开始.
     * @return 含总记录数和当前页数据的Page对象.
     */
    public Page pagedQuery(int pageNo, int pageSize, String orderBy, boolean isAsc,
               Criterion... criterions);
    
    @SuppressWarnings("unchecked")
    public List executeNativeSql(String sql);
    
    public HibernateTemplate getHibernateTemplate();
    
    /**
     * 在不同的session中关联修改过的托管对象
     */
    public void update(T entity);

    public List<T> findBy(List<String> propertyNames, List<Object> values);
}