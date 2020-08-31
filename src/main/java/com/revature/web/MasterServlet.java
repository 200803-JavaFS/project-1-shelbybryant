package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.ManagerController;

public class MasterServlet extends HttpServlet{

	private static ManagerController mc = new ManagerController();
	private static EmployeeController ec = new EmployeeController();
	
	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json"); //by default, tom cat will send back a successful status code if it find a servlet method
		//because all request will hit this method, we will default to not found and the override for success
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project-1-shelbybryant/", "");
		
		String[] portions = URI.split("/"); //going to section the URI
		System.out.println(Arrays.toString(portions)); //to see how it looks
		
		try {
			switch(portions[0]) {
			case "reimbursement":
				if(req.getMethod().equals("GET")) {
					if(portions.length == 2) {
						int reimbId = Integer.parseInt(portions[1]);
						mc.getReimbursement(res, reimbId);
					} else if (portions.length == 1) {
						mc.getAllReimbursements(res);
					}
				} else if (req.getMethod().equals("POST")) {
					ec.addReimbursement(req, res);	
				}
			
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("The id you provided is not an integer");
			res.setStatus(404);
		}

		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
		
		
	}
	
	
}
