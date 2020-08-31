package com.revature.service;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;

public class EmployeeService {

	ReimbursementDAO rDao = new ReimbursementDAO();
	
	//login
	
	
	
	//view past tickets
	public List<Reimbursement> findAll() {
		return rDao.findAll();
	}
	
	
	//add reimbursement request
	public boolean addRequest(Reimbursement reimb) {
		if(rDao.addReimbursement(reimb)) {
			return true;
		} else {
			return false;
			//add log
		}
	}
	
	//view by status
	public Reimbursement viewByStatusId(int statusId) {
		return rDao.findByStatusId(statusId);
	}
	//must automatically set the reimb_id to pending
	
	
}
