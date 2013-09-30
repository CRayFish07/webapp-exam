package edisonbetter.webexam.service;

import java.util.List;

import edisonbetter.webexam.infra.model.BaseEntity;

public interface GenericService<T extends BaseEntity> {
	
	public void create(T instance);
	
	public void update(T instance);
	
	public void delete(T instance);
	
	public T query(Class<T> clazz, String uuid);
	
	public List<T> list(Class<T> clazz);
}
