package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRoles;
import com.revature.service.LoginService;
import com.revature.service.ReimbStatusService;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

public class Tests {

	//initialize the services
	public static LoginService ls;
	public static UserService us;
	public static ReimbursementService rs;
	public static ReimbStatusService reimbStatSer;
	static UserRoles testRole;
	static User testUser;
	static ReimbursementStatus reimbStatus;
	static ReimbursementType reimbType;
	static Reimbursement reimb;

	public Tests() {
		super();
	}
	
	@BeforeClass
	public static void setUp() {
		System.out.println("in before class");
		ls = new LoginService();
		us = new UserService();
		rs = new ReimbursementService();
	}
	
	
	//before anything runs, create rs object
	@Before
	public void startUp() {
		System.out.println("in the before");
		testRole = new UserRoles(2, "Employee");
		testUser = new User("usernametest", "password", "firstName", "lastName", "email", testRole);
		
		reimbStatus = new ReimbursementStatus (1, "pending");
		reimbType = new ReimbursementType (1, "food");
		reimb = new Reimbursement (25.25, "description", testUser, null, reimbStatus, reimbType);
	}

	//did fine running by itself but not with group
//	@Test
//	public void addReimbTest() {
//		boolean reimbAdd = rs.addRequest(reimb);
//		assertTrue(reimbAdd);
//	}
	
	//did fine running by itself but not with group
//	@Test
//	public void addUserTest() {
//		boolean userAdd = us.addUser(testUser);
//		assertEquals(true, userAdd);
//	}

	//this one works
//	@Test
//	public void findAllReimbTest() {
//		List<Reimbursement> reimbList = rs.findAll();
//		assertTrue(reimbList != null);
//	}
	
	//ran fine by itself but not with the group
//	@Test
//	public void getUserById() {
//		User u = us.findById(3);
//		User testAgainst = new User (3, "username", "password", "firstName", "lastName", "email", testRole);
//		assertEquals(u, testAgainst);
//	}
	
	//this one works
//	@Test
//	public void findAllUsers() {
//		List<User> userList = us.findAll();
//		assertTrue(userList != null);
//	}
	
	//this one works
//	@Test
//	public void updateUser() {
//		User u = us.findById(1);
//		//changing/updating the email
//		//will need to change again after testing if it works before presenting
//		u.setEmail("myemail@gmial.com");
//		boolean newUser = us.updateUser(u);
//		assertTrue(newUser);
//	}
	
	//ran fine by itself but not with the group
//	@Test
//	public void updateReimb() {
//		Reimbursement r = rs.findById(1);
//		boolean reimbBool = rs.updateReimb(r);
//		Reimbursement reimbTestAgainst = new Reimbursement (1, 100.50, "description", testUser, null, reimbStatus, reimbType);
//	}
	
	//still need find by username, get by reimb id, and login
	@AfterClass
	public static void reset() {
		testRole= null;
		testUser= null;
		reimbStatus= null;
		reimbType= null;
		reimb= null;
		ls = null;
		us = null;
		rs = null;
		reimbStatSer= null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
