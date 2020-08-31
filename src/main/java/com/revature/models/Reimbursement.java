package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement")
public class Reimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reimb_id")
	private int reimbId;
	@Column(name="reimb_amount")
	private double reimbAmount;
	@Column(name="reimb_description")
	private String reimbDescription;
	@OneToOne
	@MapsId
	@JoinColumn(name="user_id")
	private int reimbAuthor;
	@OneToOne
	@MapsId
	@JoinColumn(name="user_id")
	private int reimbResolver;
	@Column(name="reimb_submitted")
	private Timestamp reimbSubmitted;
	@Column(name="reimb_resolved")
	private Timestamp reimbResolved;
	//create objects for the foreign keys
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_status_id")
	private ReimbursementStatus reimbStatusId;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_type_id")
	private ReimbursementType reimbTypeId;
	
	
	public Reimbursement() {
		super();
		
	}
	
	
	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimb_resolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}


	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}



	public ReimbursementStatus getReimbStatusId() {
		return reimbStatusId;
	}



	public void setReimbStatusId(ReimbursementStatus reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}



	public ReimbursementType getReimbTypeId() {
		return reimbTypeId;
	}



	public void setReimbTypeId(ReimbursementType reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	

	
}
