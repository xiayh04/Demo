package org.ihsp.data.dao.base.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJdbcDao extends JdbcDaoSupport {

    private static final Logger log = Logger
            .getLogger(SpringJdbcDao.class);

    @PostConstruct
    public void init() {

        log.info("Initialising jdbc dao support");
    }

    @Autowired
    public void addSF(DataSource dataSource) {
        log.info("add datasource-->" + dataSource);
        setDataSource(dataSource);
    }

    public SqlRowSet getRowSet(String queryString) {

        return getJdbcTemplate().queryForRowSet(queryString);
    }

    public SqlRowSet getRowSet(String queryString, Object[] args) {

        return getJdbcTemplate().queryForRowSet(queryString, args);
    }

    public List<Map<String, Object>> queryForList(String queryString,
            Object[] args) {

        return getJdbcTemplate().queryForList(queryString, args);
    }

    public List<Map<String, Object>> queryForList(String queryString) {

        return getJdbcTemplate().queryForList(queryString);
    }

    public int updateSql(String sql, Object... args) {
        return getJdbcTemplate().update(sql, args);
    }

    public int executeDelete(String sql) {
        SqlUpdate deleteQueryById;
        deleteQueryById = new SqlUpdate(super.getDataSource(), sql);
        deleteQueryById.compile();
        return deleteQueryById.update();
    }

    public int executeInsert(String sql) {
        Validate.notNull(sql);
        SqlUpdate sqlInsertQuery = new SqlUpdate(getDataSource(), sql);
        sqlInsertQuery.compile();
        return sqlInsertQuery.update();
    }

    @PreDestroy
    public void cleanUp() {

    }
}
