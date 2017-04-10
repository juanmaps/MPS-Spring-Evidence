package com.towasoftware.springmvcexample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.towasoftware.springmvcexample.daos.UserDAO;
import com.towasoftware.springmvcexample.model.User;

@Service
public class UserService implements IService<User> {

	@Autowired
	UserDAO userDao;

	/**
	 * Método para guardar un nuevo Usuario
	 */
	@Override
	public User save(User entity) {

		this.userDao.persist(entity);
		
		return entity; 
	}

	/**
	 * Método para obtener todos los usuarios
	 */
	@Override
	public List<User> getAll() {
		
		return this.userDao.fetchAll();
	}

	/**
	 * Método para buscar un usuario por su ID
	 */
	@Override
	public User findById(Long id) {
		
		return this.userDao.fetchById(id);
	}

	/**
	 * Método para actualizar un usuario
	 */
	@Override
	public User update(User entity) {
		
		return this.userDao.update(entity);
		
	}

	/**
	 * Método para borar un usuario
	 */
	@Override
	public Boolean delete(User entity) {

		return this.userDao.delete(entity);
		
	}

}
