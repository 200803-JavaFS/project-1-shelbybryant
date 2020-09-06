package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class ReimbursementTypeDAO {

	public ReimbursementType findbyTypeId (int id) {
		Session session = HibernateUtil.getSession();
		List <ReimbursementType> reimbTypeList = session.createQuery("from ReimbursementType where reimbTypeId = '" + id + "'", ReimbursementType.class).list();
		ReimbursementType reimbType = reimbTypeList.get(id);
		return reimbType;
	}
	
	
}
