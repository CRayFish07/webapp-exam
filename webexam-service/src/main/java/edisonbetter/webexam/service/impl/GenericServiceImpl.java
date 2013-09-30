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
	public void create(T instance) {
		dao.setEntity((Class<T>)instance.getClass());
		dao.create(instance);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T instance) {
		dao.setEntity((Class<T>)instance.getClass());
		dao.update(instance);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T instance) {
		dao.setEntity((Class<T>)instance.getClass());
		dao.delete(instance);
	}

	@Override
	public T query(Class<T> clazz, String uuid) {
		dao.setEntity(clazz);
		return dao.read(uuid);
	}

	@Override
	public List<T> list(Class<T> clazz) {
		dao.setEntity(clazz);
		return dao.list();
	}

}
