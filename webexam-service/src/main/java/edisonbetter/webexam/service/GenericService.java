package edisonbetter.webexam.service;

import java.util.List;

import edisonbetter.webexam.infra.model.BaseEntity;

public interface GenericService<T extends BaseEntity> {
	
	public void create(T baseEntity);
	
	public void update(T baseEntity);
	
	public void delete(T baseEntity);
	
	public T query(String uuid);
	
	public List<T> list();
}
