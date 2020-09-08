package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.List;

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
import com.revature.service.ReimbTypeService;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

public class Tests {

	//initialize the services
	public static LoginService ls;
	public static UserService us;
	public static ReimbursementService rs;
	public static ReimbStatusService reimbStatSer;
	public static ReimbTypeService reimbTypeSer;
	
	static UserRoles testRole;
	static UserRoles testManRole;
//	static User testUser;
	static User testManager;
	static ReimbursementStatus reimbStatusTest;
	static ReimbursementType reimbTypeTest;
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
		reimbStatSer = new ReimbStatusService();
		reimbTypeSer = new ReimbTypeService();
	}
	
	
	//before anything runs, create rs object
	@Before
	public void startUp() {
		System.out.println("in the before");
		//1 is employee, 2 is manager
		testRole = new UserRoles(2, "employee");
		testManRole = new UserRoles(1, "manager");
		//users we want to add
		//testUser = new User(6, "usernametest2", "password", "firstName", "lastName", "Testemail", testRole);
		//testManager = new User(8, "usernameTest", "passwordTest", "firstNameTest", "lastNameTest", "emailTest", testManRole);
		
		reimbStatusTest = new ReimbursementStatus (1, "pending");
		reimbTypeTest = new ReimbursementType (3, "food");
		//reimb to add, but not using the reimb id
//		reimb = new Reimbursement (10.10, "description", us.findById(1), null, reimbStatusTest, reimbTypeTest);
	}

	//this works
	@Test
	public void testLogin() {
		System.out.println("in login");
		
		User user = new User(1, "obers", "theforce", "Obi", "Wan", "theforce@gmail.com", testManRole);
		System.out.println(user);
		boolean loginBool = ls.login(user);
		System.out.println("\n\n-----------------\n\nLOGIN RESULT:" + loginBool);
		assertTrue(loginBool);
	}
	
	//this works
	@Test
	public void getReimbById() {
		System.out.println("\n\nin find reimb by id");
		
		int id = 1;
		
		Reimbursement r = rs.findById(id);
		
		assertEquals(r.getReimbId(), id);
		assertEquals(r.getReimbStatus(), new ReimbursementStatus (2, "approved"));
	}
	
	//did fine running by itself but not with group
	@Test
	public void addReimbTest() {
		reimb = new Reimbursement(45.45, "work trip to taco bell", us.findById(2), null, new Timestamp(System.currentTimeMillis()), null, reimbStatusTest, reimbTypeTest);
		boolean reimbAdd = rs.addRequest(reimb);
		System.out.println("\n\n-----------------\n\nREIMB ADD BOOLEAN: " + reimbAdd);
		assertTrue(reimbAdd);
		
	}
	
	
	//did fine running by itself but not with group
	@Test
	public void addUserTest() {
		User testUser = new User ("nando2", "password1", "Fernando", "Flores", "nando2@gmail.com", testRole);
		boolean userAdd = us.addUser(testUser);
		System.out.println("\n\n-----------------\n\nUSER ADD BOOLEAN: " + userAdd);
		assertTrue(userAdd);
	}

	//this one works
	@Test
	public void findAllReimbTest() {
		List<Reimbursement> reimbList = rs.findAll();
		assertTrue(reimbList != null);
	}
	
	//ran fine by itself but not with the group
	@Test
	public void getUserById() {
		System.out.println("in get user by id");
		int id = 2;
		User u = us.findById(id);
		assertEquals(u.getUserId(), id);
	}
	
	//this one works
	@Test
	public void findAllUsers() {
		List<User> userList = us.findAll();
		assertTrue(userList != null);
	}
	
	//this one works
	@Test
	public void updateUser() {
		int id = 1;
		User u = us.findById(id);
		//changing/updating the email
		//will need to change again after testing if it works before presenting
		u.setEmail("theforce@gmail.com");
		boolean newUser = us.updateUser(u);
		assertTrue(newUser);
	}
	
	//ran fine by itself but not with the group
	@Test
	public void updateReimb() {
		int id = 3;
		Reimbursement r = rs.findById(id);
		r.setReimbAmount(150.50);
		boolean newReimb = rs.updateReimb(r);
		assertTrue(newReimb);

	}
	
	//this works
	@Test
	public void findReimbByStatusId() {
		System.out.println("in finding reimb by status id");
		//id 1 = pending
		int id = 1;
		
		List<Reimbursement> rList = rs.findByStatus(id);
		assertTrue(rList != null);
		
	}
	
	//this works
	@Test
	public void findReimbByUser() {
		//user id 1 == obi
		int id = 1;
		User user = us.findById(id);
		List <Reimbursement> rList = rs.getAllByAuthor(user);
		assertTrue(rList != null);
	}
	
	//this works
	@Test
	public void findReimbByTypeId () {
		System.out.println("in finding reimb by type id");
		
		int id = 3;
		
		List<Reimbursement> rList = rs.findByTypeId(id);
		assertTrue(rList != null);
	}
	
	
	@AfterClass
	public static void reset() {
		testRole= null;
	//	testUser= null;
		reimbStatusTest= null;
		reimbTypeTest= null;
		reimb= null;
		ls = null;
		us = null;
		rs = null;
		reimbStatSer= null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
