/**
 * 
 */
package edisonbetter.webexam.infra.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Edison Yang
 *
 */
public interface DataAccessObject<T> {
	
	public void setEntity(Class<T> entityClass);
	public Class<T> getEntityClass();
	public void create(T instance);
	public T read(Serializable primaryKeyValue);
	public void update(T instance);
	public void delete (T instance);
	public List<T> list(); 
}
