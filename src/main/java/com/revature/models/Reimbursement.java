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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="reimbursement")
public class Reimbursement {

	private static final long serialVersionUDI = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reimb_id")
	private int reimbId;
	
	@Column(name="reimb_amount", nullable=false)
	private double reimbAmount;
	
	@Column(name="reimb_description")
	private String reimbDescription;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_author")
	private User reimbAuthorId;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_resolver")
	private User reimbResolverId;
	
	@CreationTimestamp
	@Column(name="reimb_submitted", nullable=false)
	private Timestamp reimbSubmitted;
	
	@UpdateTimestamp
	@Column(name="reimb_resolved")
	private Timestamp reimbResolved;
	
	//create objects for the foreign keys
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_status_id_fk", nullable=false)
	private ReimbursementStatus reimbStatus;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_type_id_fk", nullable=false)
	private ReimbursementType reimbType;
	
	
	public Reimbursement() {
		super();
		
	}


	public Reimbursement(double reimbAmount, String reimbDescription, User reimbAuthorId,
			ReimbursementStatus reimbStatus, ReimbursementType reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorId = reimbAuthorId;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}


	public Reimbursement(double reimbAmount, String reimbDescription, User reimbAuthorId, User reimbResolverId,
			Timestamp reimbSubmitted, Timestamp reimbResolved, ReimbursementStatus reimbStatus,
			ReimbursementType reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorId = reimbAuthorId;
		this.reimbResolverId = reimbResolverId;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}



	public Reimbursement(int reimbId, double reimbAmount, String reimbDescription, User reimbAuthorId,
			User reimbResolverId, Timestamp reimbSubmitted, Timestamp reimbResolved, ReimbursementStatus reimbStatus,
			ReimbursementType reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorId = reimbAuthorId;
		this.reimbResolverId = reimbResolverId;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbDescription="
				+ reimbDescription + ", reimbAuthorId=" + reimbAuthorId + ", reimbResolverId=" + reimbResolverId
				+ ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbStatus="
				+ reimbStatus + ", reimbType=" + reimbType + "]";
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


	public User getReimbAuthorId() {
		return reimbAuthorId;
	}


	public void setReimbAuthorId(User reimbAuthorId) {
		this.reimbAuthorId = reimbAuthorId;
	}


	public User getReimbResolverId() {
		return reimbResolverId;
	}


	public void setReimbResolverId(User reimbResolverId) {
		this.reimbResolverId = reimbResolverId;
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


	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}


	public ReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}


	public void setReimbStatus(ReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}


	public ReimbursementType getReimbType() {
		return reimbType;
	}


	public void setReimbType(ReimbursementType reimbType) {
		this.reimbType = reimbType;
	}


	public static long getSerialversionudi() {
		return serialVersionUDI;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimbAuthorId == null) ? 0 : reimbAuthorId.hashCode());
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + reimbId;
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + ((reimbResolverId == null) ? 0 : reimbResolverId.hashCode());
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthorId == null) {
			if (other.reimbAuthorId != null)
				return false;
		} else if (!reimbAuthorId.equals(other.reimbAuthorId))
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbResolverId == null) {
			if (other.reimbResolverId != null)
				return false;
		} else if (!reimbResolverId.equals(other.reimbResolverId))
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		return true;
	}





	


	

	
}
