package com.revature.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Reimbursement;
import com.revature.service.ReimbursementService;

public class FindByStatusTest {

	public static ReimbursementService rs;
	
	
	public static int statusId1;
	public static int statusId2;
	public static int statusId3;
	public static int resultId;
	
	
	//before anything runs, create rs object
	@BeforeClass
	public static void setRS() {
		System.out.println("in the before class of find by status");
		rs = new ReimbursementService();
	}

	@Before
	public void setUp() {
		System.out.println("in before");
		statusId1 = 1;
		statusId2 = 2;
		statusId3 = 3;
	}
	
	@After
	public void clearResult() {
		System.out.println("in after of find by status");
		resultId = 0;
	}
	
	@AfterClass
	public void clearRS() {
		System.out.println("in after class of find by status");
		rs = null;
	}
	
	
	@Test
	public void testFindByStatus() {
		System.out.println("testing find by status");
		List<Reimbursement> result = rs.findByStatus(statusId1);
		assertTrue(result == rs.findByStatus(1));
		 
	}
	

	
	
}
