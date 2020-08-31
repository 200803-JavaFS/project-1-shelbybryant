package com.revature.service;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;

public class ManagerService extends Reimbursement{

	ReimbursementDAO rDao = new ReimbursementDAO();
	
	//login
	
	
	
	//view all reimbursements for all employees
	public List<Reimbursement> findAl() {
		return rDao.findAll();
	}
	
	//get by reimb id
	
	public Reimbursement findById(int reimbId) {
		return rDao.findById(reimbId);
	}
	
	
	//filter requests by status
	public Reimbursement findByStatusId(int statusId) {
		return rDao.findByStatusId(statusId);
	}
	
	
	//approve or deny the requests
	
	public boolean approveDenyReimb (Reimbursement reimb) {
		if(rDao.updateReimbursement(reimb)) {
			return true;
		} else {
			return false;
			//put log here
		}
	}
	
	
}
