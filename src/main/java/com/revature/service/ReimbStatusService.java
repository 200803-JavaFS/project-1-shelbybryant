package com.revature.service;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ReimbursementStatusDAO;
import com.revature.models.ReimbursementStatus;

public class ReimbStatusService {

	private static final Logger log = LogManager.getLogger(ReimbStatusService.class);
	private static ReimbursementStatusDAO rsDao = new ReimbursementStatusDAO();
	
	public ReimbursementStatus findByStatus(int statusId) {
		log.info("Finding ReimbStatus with status: "+ statusId);
		return rsDao.selectByStatus(statusId);
	}
	
}
