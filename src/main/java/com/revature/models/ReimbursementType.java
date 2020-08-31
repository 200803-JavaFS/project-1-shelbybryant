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
@Table(name="reimbursement_type")
public class ReimbursementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reimb_type_id")
	private int reimbTypeId;
	@Column(name="reimb_type")
	private String reimbType;
	@OneToMany(mappedBy="reimbTypeId", fetch=FetchType.EAGER)
	private List<ReimbursementType> rt;
	
	
	
	public ReimbursementType() {
		super();
		
	}
	
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}
	
	
	
	
	
	
}
