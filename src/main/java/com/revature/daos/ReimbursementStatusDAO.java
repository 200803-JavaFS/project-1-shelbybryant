package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.utils.HibernateUtil;

public class ReimbursementStatusDAO {

	public ReimbursementStatus selectByStatus(int statusId) {
		Session session = HibernateUtil.getSession();
		List<ReimbursementStatus> reimbStatusList = session.createQuery("from ReimbursementStatus where reimbStatusId = " 
		+ statusId +"'", ReimbursementStatus.class).list();
		
		return reimbStatusList.get(statusId);
	}
	
}
