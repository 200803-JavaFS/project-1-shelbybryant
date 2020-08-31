package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session session;
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	//example of singleton design pattern
	public static Session getSession() {
		if(session == null) {
			session = sf.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		session.close();
		session = null;
	}
	
}
