package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ReimbursementDAO {

	public List <Reimbursement> findAll() {
		Session session = HibernateUtil.getSession();
		List <Reimbursement> reimbList = session.createQuery("FROM reimbursement").list();
		return reimbList;
	}
	
	public Reimbursement findById(int reimbId) {
		Session session = HibernateUtil.getSession();
		Reimbursement reimb = session.get(Reimbursement.class, reimbId);
		return reimb;
	}
	
	public boolean addReimbursement(Reimbursement reimb) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.save(reimb);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateReimbursement(Reimbursement reimb) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.merge(reimb);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteById(int reimbId) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.createQuery("DELETE FROM reimbursement WHERE reimb_id = " +reimbId);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Reimbursement findByStatusId(int statusId) {
		Session session = HibernateUtil.getSession();
		Reimbursement reimb = session.get(Reimbursement.class, statusId);
		return reimb;
	}
	
	public List<Reimbursement> getAllByAuthor(User author) {
		Session session = HibernateUtil.getSession();
		List<Reimbursement> list = session.createQuery("FROM Reimbursement WHERE reimbAuthor = " +
		author.getUserId(), Reimbursement.class).list();
		return list;
	}
}
