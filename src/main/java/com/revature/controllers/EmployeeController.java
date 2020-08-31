package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.service.EmployeeService;

public class EmployeeController {

	private static EmployeeService es = new EmployeeService();
	private static ObjectMapper om = new ObjectMapper();
	
	
	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder stringBuilder = new StringBuilder();
		
		String line = reader.readLine();
		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine();
		}
		
		String body = new String(stringBuilder);
		Reimbursement reimb = om.readValue(body, Reimbursement.class);
		
		if(es.addRequest(reimb)) {
			res.setStatus(201); //created status code
			res.getWriter().println("The request was created.");
		} else {
			res.setStatus(403);
		}
	}
	
	
	
}
