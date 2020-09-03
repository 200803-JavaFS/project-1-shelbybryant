package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

public class UserController {

	private static UserService us = new UserService();
	private static ObjectMapper om= new ObjectMapper();
	private static ReimbursementService rs = new ReimbursementService();
	
	
	public void setUserRole(HttpServletRequest req, HttpServletResponse res, User user) throws IOException {
		System.out.println("in method to sent user role as object");		
		if(user==null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			String json = om.writeValueAsString(user);
			res.getWriter().println(json);
		}
		
	}
	
	
}
