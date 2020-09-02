package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
import com.revature.service.ReimbursementService;


public class MasterServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	private static LoginController lc = new LoginController();
	private static ReimbursementService rs = new ReimbursementService();
	
	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json"); //by default, tom cat will send back a successful status code if it find a servlet method
		//because all request will hit this method, we will default to not found and the override for success
		res.setStatus(400);
		
		final String URI = req.getRequestURI().replace("/project1/", "");
		String[] portions = URI.split("/"); //going to section the URI
		
		if (portions.length == 0) {
			req.getRequestDispatcher("index.html").forward(req, res);
		}

		try {
			switch (portions[0]) {
				case "login":
					lc.login(req, res);
					break;
				case "logout":
					lc.logout(req, res);
					break;
				case "addTicket":
					//rs.addRequest(reimb);
				default:
					System.out.println("The option you chose was not offered.");
						
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		

		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
		
		
	}
	
	
}
