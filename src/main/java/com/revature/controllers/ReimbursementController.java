package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.service.ReimbStatusService;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

public class ReimbursementController {

	private static ReimbursementService rs = new ReimbursementService();
	private static ReimbStatusService rss = new ReimbStatusService();
	private static UserService us = new UserService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void addTicket (HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		String line= reader.readLine();
		
		while (line != null) {
			s.append(line);
			line = reader.readLine();								
		}
		String body = new String(s);
		
		System.out.println("body:" + body);
		
		//Create a temporary instance without foreign key properties from body
		ReimbursementDTO reimbdto = om.readValue(body, ReimbursementDTO.class);
		System.out.println("reimbursement dto: " + reimbdto);
	
		
		double reimbAmount = reimbdto.getReimbAmount();
		String reimbDesc = reimbdto.getReimbDescription();
		User author = us.findById(reimbdto.getReimbAuthorId());
		ReimbursementStatus newReimbStatus = new ReimbursementStatus(1, "pending");
		
		String type = reimbdto.getReimbType();
		
		ReimbursementType reimbType = null;
		if (type.toLowerCase().equals("travel")) {
			reimbType = new ReimbursementType(1, "travel");
		} else if (type.toLowerCase().equals("lodging")) {
			reimbType = new ReimbursementType(2, "lodging");
		} else if (type.toLowerCase().equals("food")) {
			reimbType = new ReimbursementType(3, "food");
		} else if (type.toLowerCase().equals("other")) {
			reimbType = new ReimbursementType(4, "other");
		}
		
		Reimbursement newReimb = new Reimbursement (reimbAmount, reimbDesc, author, newReimbStatus, reimbType);
		System.out.println("new reimbursement" + newReimb);
		
		if (rs.addRequest(newReimb)) {
			res.setStatus(200);
			res.getWriter().println("Reimbursement was created");
		} else {
			res.setStatus(403);
		}
		
	}
	
	public void findByAuthorId (HttpServletResponse res, int id) throws IOException {
		User user = us.findById(id);
		List<Reimbursement> reimbList = rs.getAllByAuthor(user);
		
		if (reimbList.isEmpty()) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String jsonString = om.writeValueAsString(reimbList);
			res.getWriter().println(jsonString);
		}
	}
	
	public void getAllReimbByStatus (HttpServletResponse res, int statusId) throws IOException {
		
		List<Reimbursement> allReimb = rs.findByStatus(statusId);
		
		if (allReimb.isEmpty()) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(allReimb);
			res.getWriter().println(json);
		}
	}
	
	public void updateStatus (HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader= req.getReader();
		StringBuilder s=new StringBuilder();
		String line = reader.readLine();
		while(line!=null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		ReimbursementDTO reimbdto= om.readValue(body, ReimbursementDTO.class);
		
		int reimbId = reimbdto.getId();
		Reimbursement reimb = rs.findById(reimbId);
		
		String status = reimbdto.getReimbStatus();
		System.out.println("new status: " + status);
		
		ReimbursementStatus reimbStatus = null;
		if (status.equals("approved")) {
			reimbStatus = new ReimbursementStatus(2, "approved");
		} else if (status.equals("denied")) {
			reimbStatus = new ReimbursementStatus(3, "denied");
		}
		
		int resolverId = reimbdto.getReimbResolverId();
		System.out.println("resolver id: " + resolverId);
		
		reimb.setReimbStatus(reimbStatus);
		User resolver = us.findById(resolverId);
		System.out.println("resolver: " + resolver);
		reimb.setReimbResolverId(resolver);
		System.out.println(reimb);
		
		if (rs.updateReimb(reimb)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement was updated");
		} else {
			res.setStatus(403);
		}
	}
	
	
	public void getAllReimb (HttpServletResponse res) throws IOException {
		List<Reimbursement> allReimb = rs.findAll();
		res.setStatus(200);
		String json = om.writeValueAsString(allReimb);
		res.getWriter().println(json);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
