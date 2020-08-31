package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_status")
public class ReimbursementStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reimb_status_id")
	private int reimbStatusId;
	@Column(name="reimb_status")
	private String reimbStatus;
	@OneToMany(mappedBy="reimbStatusId", fetch=FetchType.EAGER)
	private List<ReimbursementStatus> rs;
	
	
	@Override
	public String toString() {
		return "ReimbursementStatus [reimbStatusId=" + reimbStatusId + ", reimbStatus=" + reimbStatus + "]";
	}

	public ReimbursementStatus() {
		super();
	
	}
	
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	
	
}
