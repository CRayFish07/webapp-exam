/**
 * 
 */
package edisonbetter.webexam.infra.dao.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import edisonbetter.webexam.infra.dao.DataAccessObject;

/**
 * @author Edison Yang
 *
 */
public class HibernateDAO<T> implements DataAccessObject<T> {
	private Class<T> entityClass;
	private SessionFactory sessionFactory;
	
	public HibernateDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void setEntity(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public Class<T> getEntityClass() {
		return this.entityClass;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@Transactional
	public void create(T instance) {
		getSession().save(instance);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T read(Serializable primaryKeyValue) {
		return (T)getSession().get(entityClass, primaryKeyValue);
	}

	@Override
	@Transactional
	public void update(T instance) {
		getSession().update(instance);
	}

	@Override
	@Transactional
	public void delete(T instance) {
		getSession().delete(instance);
	}

}
