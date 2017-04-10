package com.towasoftware.springmvcexample.services;

import java.util.List;

public interface IService<T> {

	public T save(T entity);

	public List<T> getAll();

	public T findById(Long id);

	public T update(T entity);

	public Boolean delete(T entity);
}
