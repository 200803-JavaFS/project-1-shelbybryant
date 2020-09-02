package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.UserRoles;
import com.revature.utils.HibernateUtil;

public class UserRoleDAO {

	public UserRoles getById(int id) {
		Session session = HibernateUtil.getSession();
		UserRoles ur = session.get(UserRoles.class, id);
		return ur;
	}
}
