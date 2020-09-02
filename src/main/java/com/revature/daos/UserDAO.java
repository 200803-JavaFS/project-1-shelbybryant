package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDAO {

	public List<User> findAll() {
		Session session = HibernateUtil.getSession();
		List<User> userList = session.createQuery("from User").list();
		return userList;
	}
	
	public User findById(int userId) {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, userId);
		return user;
	}
	
	public boolean addUser(User user) {
		Session session = HibernateUtil.getSession();
		try {
			session.save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateUser(User user) {
		Session session = HibernateUtil.getSession();
		try {
			session.merge(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deletById(int userId) {
		Session session = HibernateUtil.getSession();
		try {
			session.createQuery("delete from user where user_id = " + userId);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public User getByUsername(String username) {
		Session session = HibernateUtil.getSession();
		String query = "from User where username = " + "'" + username + "'";
		List<User> list = session.createQuery(query).list();
		return list.get(0);
	}
	

}
