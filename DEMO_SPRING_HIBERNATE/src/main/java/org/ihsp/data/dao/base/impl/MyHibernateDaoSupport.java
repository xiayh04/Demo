package org.ihsp.data.dao.base.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class MyHibernateDaoSupport extends HibernateDaoSupport {
	Log log = LogFactory.getLog(MyHibernateDaoSupport.class);

	@Autowired
	// 为父类HibernateDaoSupport注入sessionFactory的值
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		log.info("setSuperSessionFactory~sessionFactory: " + sessionFactory);
		setSessionFactory(sessionFactory);
	}

	protected Session getSession() throws DataAccessResourceFailureException {
		return super.currentSession();
	}
	/*
	 * @Autowired public void setSuperHibernateTemplate(HibernateTemplate
	 * hibernateTemplate){
	 * log.info("setSuperHibernateTemplate~hibernateTemplate: "
	 * +hibernateTemplate); super.setHibernateTemplate(hibernateTemplate); }
	 */

}