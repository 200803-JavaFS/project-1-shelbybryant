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
	
	
	public ReimbursementType(String reimbType, List<ReimbursementType> rt) {
		super();
		this.reimbType = reimbType;
		this.rt = rt;
	}


	public ReimbursementType(int reimbTypeId, String reimbType, List<ReimbursementType> rt) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
		this.rt = rt;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + reimbTypeId;
		result = prime * result + ((rt == null) ? 0 : rt.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementType other = (ReimbursementType) obj;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (reimbTypeId != other.reimbTypeId)
			return false;
		if (rt == null) {
			if (other.rt != null)
				return false;
		} else if (!rt.equals(other.rt))
			return false;
		return true;
	}
	
	
	
	
	
	
}
