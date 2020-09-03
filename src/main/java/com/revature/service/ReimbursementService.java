package com.revature.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementStatusDAO;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementService {

	private static final Logger log = LogManager.getLogger(ReimbursementService.class);
	private static ReimbursementDAO rDao = new ReimbursementDAO();

	
	//view past tickets
	public List<Reimbursement> findAll() {
		log.info("Getting all the reimbursements!");
		return rDao.findAll();
	}
	
	
	//add reimbursement request
	public boolean addRequest(Reimbursement reimb) {
		if (rDao.addReimbursement(reimb)) {
			return true;
		} else {
			return false;
			//add log
		}
	}
	
	public List<Reimbursement> findByStatus(int statusId){
		return rDao.selectByStatus(statusId);
	}
	
	public List<Reimbursement> getAllByAuthor(User author) {
		log.info("Getting all the reimbursements by the author of " + author);
		return rDao.getAllByAuthor(author);
	}
	
	public Reimbursement findById (int id) {
		log.info("Retrieving reimbursement with the id of: " + id);
		return rDao.findById(id);
	}
	
	public boolean updateReimb (Reimbursement reimb) {
		log.info("Updating reimbursement: " + reimb);
		return rDao.updateReimbursement(reimb);
	}
}
