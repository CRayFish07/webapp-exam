package edisonbetter.webexam.service.impl;

import java.util.List;

import edisonbetter.webexam.infra.dao.DataAccessObject;
import edisonbetter.webexam.infra.model.BaseEntity;
import edisonbetter.webexam.service.GenericService;

public class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {
	
	private DataAccessObject<T> dao;

	public void setDao(DataAccessObject<T> dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(T baseEntity) {
		dao.setEntity((Class<T>)baseEntity.getClass());
		dao.create(baseEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T baseEntity) {
		dao.setEntity((Class<T>)baseEntity.getClass());
		dao.update(baseEntity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T baseEntity) {
		dao.setEntity((Class<T>)baseEntity.getClass());
		dao.delete(baseEntity);
	}

	@Override
	public T query(String uuid) {
		//dao.setEntity(T);
		return dao.read(uuid);
	}

	@Override
	public List<T> list() {
		//dao.setEntity(T);
		return dao.list();
	}

}
