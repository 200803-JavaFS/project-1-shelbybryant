package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.service.ManagerService;

public class ManagerController {
	
	private static ManagerService ms = new ManagerService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getReimbursement(HttpServletResponse res, int reimbId) throws IOException {
		Reimbursement reimb = ms.findById(reimbId);
		
		if (reimb == null ) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(reimb);
			res.getWriter().println(json);
		}
	}
	
	public void getReimbursementByStatus(HttpServletResponse res, int statusId) throws IOException {
		Reimbursement reimb = ms.findByStatusId(statusId);
		
		if (reimb == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(reimb);
			res.getWriter().println(json);
		}
	}
	
	public void getAllReimbursements(HttpServletResponse res) throws IOException {
		List <Reimbursement> allReimb = ms.findAl();
		res.getWriter().println(om.writeValueAsString(allReimb));
		res.setStatus(200);
	}
	
}
