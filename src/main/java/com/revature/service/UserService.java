package com.revature.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.UserDAO;
import com.revature.models.User;

public class UserService {

	private static final Logger log = LogManager.getLogger(UserService.class);
	private static UserDAO uDao = new UserDAO();
	
	public List<User> findAll() {
		log.info("Getting all Users");
		return uDao.findAll();
	}
	
	public User findById(int userId) {
		log.info("Getting the user by the user id of " + userId);
		return uDao.findById(userId);
	}
	
	
	public boolean addUser(User user) {
		log.info("Adding a new User "+user);
		return uDao.addUser(user);
	}
	
	public boolean updateUser(User user) {
		log.info("Updating User "+user);
		return uDao.updateUser(user);
	}
	
	public User getByUsername (String username) {
		log.info("Getting the user with the username of " + username);
		return uDao.getByUsername(username);
	}
	
	public boolean deleteUser(int id) {
		log.info("Deleting user with id of " + id);
		return uDao.deletById(id);
	}
	
}
