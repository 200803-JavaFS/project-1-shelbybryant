package com.revature.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.service.ReimbursementService;

public class GetReimbByAuthor {

	public static ReimbursementService rs;
	public static User author;
	
	public static int authorId1;
	public static int authorId2;
	public static int authorId3;
	public static int resultId;
	
	//create rs object
	@BeforeClass
	public static void setRS() {
		System.out.println("in before class of find by author");
		rs = new ReimbursementService();
		author = new User();
		
	}
	
	@Before
	public void setUp() {
		System.out.println("in before of find by author");
		authorId1 = 1;
		authorId2 = 2;
		authorId3 = 3;
	}
	
	@After
	public void clearResult() {
		System.out.println("in after of find by author");
		resultId = 0;
	}
	
	@AfterClass
	public void clearRS() {
		System.out.println("in after class of find by author");
		rs = null;
	}
	
	@Test
	public void testFindByAuthor() {
		System.out.println("testing find by author");
		List<Reimbursement> result = rs.getAllByAuthor(author);
		
		//not done
	}
	
	
	
	
	
}
