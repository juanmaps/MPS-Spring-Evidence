package com.towasoftware.springmvcexample.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.towasoftware.springmvcexample.model.User;

//@Repository
public class UserDAO implements IDAO<User> {

	private HibernateTemplate hibernateTemplate;
	 
//	@Autowired
//	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public User persist(User entity) {

		// this.getHibernateTemplate().persist(entity);
		this.hibernateTemplate.save(entity);

		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> fetchAll() {

		// List<User> lstUsers = this.getHibernateTemplate().find("from
		// usuario");

		List<User> lstUsers = this.hibernateTemplate.find("from user");

		return lstUsers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User fetchById(Long id) {

		User user = null;

		// List<User> lstUsers = this.getHibernateTemplate().find("from usuario
		// where id = " + id);
		
		List<User> lstUsers = this.hibernateTemplate.find("from user where id = " + id);

		if (lstUsers != null && lstUsers.size() > 0) {
			user = lstUsers.get(0);
		}

		return user;
	}

	@Override
	public User update(User entity) {

		// this.getHibernateTemplate().update(entity);
		this.hibernateTemplate.update(entity);

		return entity;

	}

	@Override
	public Boolean delete(User entity) {

		// this.getHibernateTemplate().delete(entity);
		this.hibernateTemplate.delete(entity);
		
		return true;
	}

}
