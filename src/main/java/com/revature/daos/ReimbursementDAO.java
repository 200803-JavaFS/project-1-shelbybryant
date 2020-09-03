package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ReimbursementDAO {

	public List <Reimbursement> findAll() {
		Session session = HibernateUtil.getSession();
		List <Reimbursement> reimbList = session.createQuery("from Reimbursement").list();
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
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public boolean updateReimbursement(Reimbursement reimb) {
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.merge(reimb);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public List<Reimbursement> selectByStatus(int statusId) {
		Session ses=HibernateUtil.getSession();
		List<Reimbursement> reimbList = ses.createQuery("from Reimbursement where reimbStatus ="+statusId, Reimbursement.class).list();
		return reimbList;
	}
	
	
	public List<Reimbursement> getAllByAuthor(User author) {
		Session session = HibernateUtil.getSession();
		List<Reimbursement> list = session.createQuery("from Reimbursement where reimbAuthorId = " +
		author.getUserId(), Reimbursement.class).list();
		return list;
	}
}
