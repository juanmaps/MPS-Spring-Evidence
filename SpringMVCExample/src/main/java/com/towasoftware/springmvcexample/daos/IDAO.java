package com.towasoftware.springmvcexample.daos;

import java.util.List;

public interface IDAO<T> {

	public T persist(T entity);

	public List<T> fetchAll();

	public T fetchById(Long id);

	public T update(T entity);

	public Boolean delete(T entity);

}
