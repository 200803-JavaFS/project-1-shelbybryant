package com.revature.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ReimbursementTypeDAO;
import com.revature.models.ReimbursementType;

public class ReimbTypeService {

	private static final Logger log = LogManager.getLogger(ReimbTypeService.class);
	private static ReimbursementTypeDAO rtDao = new ReimbursementTypeDAO();
	
	public ReimbursementType findByTypeId (int id) {
		log.info("Finding the reimbursements with a status id of " + id);
		return rtDao.findbyTypeId(id);
	}
	
}
