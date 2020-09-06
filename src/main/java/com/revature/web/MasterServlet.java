package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.models.UserRoles;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;


public class MasterServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	private static LoginController lc = new LoginController();
	private static ReimbursementService rs = new ReimbursementService();
	private static UserService us = new UserService();
	private static UserController uc = new UserController();
	private static ReimbursementController rc = new ReimbursementController();
	
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
		

		try {
			switch (portions[0]) {
				case "login":
					lc.login(req, res);
					break;
//				case "success":
//					if(req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
//						User user = (User) req.getSession().getAttribute("user");
//						
//						user = us.getByUsername(user.getUsername());
//						UserRoles ur = user.getUserRoleId();
//						System.out.println(ur);
//						
//						if(req.getMethod().equals("GET")) {
//							uc.setUserRole(req, res, user);
//						}	
//					}
					//break;
				case "logout":
					lc.logout(req, res);
					break;
				case "reimbursements":
					System.out.println("in reimbursements");
					if (portions.length == 2) {
						int id = Integer.parseInt(portions[1]);
						rc.getReimbById(res, id);;
					} else {
						rc.getAllReimb(res);
					}
					break;
				case "ticket":
					System.out.println("adding a ticket");
					rc.addTicket(req, res);
					break;
				case "status":
					System.out.println("updating a status");
					rc.updateStatus(req, res);
					break;
				case "filter":
					System.out.println("filtering by status");
					if (portions.length == 2) {
						int statusId = Integer.parseInt(portions[1]);
						System.out.println(statusId);
						rc.getAllReimbByStatus(res, statusId);
					} else {
						rc.getAllReimb(res);
					}
					break;
				case "author":
					System.out.println("finding reimb by author id");
					if (portions.length == 2) {
						int authorId = Integer.parseInt(portions[1]);
						rc.findByAuthorId(res, authorId);
						System.out.println("author id is " + authorId);
					} else {
						System.out.println("could not find reimb by that author id");
					}
					break;
				default:
					System.out.println("The option you chose was not offered.");
						
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().println("The id you provided is not an integer");
			res.setStatus(400);
		}
		
		

		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
		
		
	}
	
	
}
