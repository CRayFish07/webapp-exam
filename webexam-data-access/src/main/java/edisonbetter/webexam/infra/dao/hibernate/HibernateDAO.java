/**
 * 
 */
package edisonbetter.webexam.infra.dao.hibernate;

import java.io.Serializable;

import edisonbetter.webexam.infra.dao.DataAccessObject;

/**
 * @author Edison Yang
 *
 */
public class HibernateDAO<T> implements DataAccessObject<T> {
	private Class<T> entityClass;
	
	@Override
	public void setEntity(Class<T> entityClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<T> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(T instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T read(Serializable primaryKeyValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T instance) {
		// TODO Auto-generated method stub
		
	}

}
