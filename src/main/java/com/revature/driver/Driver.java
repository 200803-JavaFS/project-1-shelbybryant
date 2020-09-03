package com.revature.driver;

import com.revature.service.ReimbursementService;

public class Driver {

	private static ReimbursementService rs = new ReimbursementService();
	
	public static void main(String[] args) {
		rs.findAll();

	}

}
