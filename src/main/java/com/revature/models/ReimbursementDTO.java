package com.revature.models;

public class ReimbursementDTO {

	public int id;
	public String reimbStatus;
	public int reimbAuthorId;
	
	public double reimbAmount;
	public String reimbDescription;
	public String reimbType;
	public int reimbResolverId;
	
	
	
	public ReimbursementDTO() {
		super();
	}



	public ReimbursementDTO(String reimbStatus, int reimbAuthorId, double reimbAmount, String reimbDescription,
			String reimbType) {
		super();
		this.reimbStatus = reimbStatus;
		this.reimbAuthorId = reimbAuthorId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbType = reimbType;
	}
	
	public ReimbursementDTO(int reimbAuthorId, double reimbAmount, String reimbDescription,
			String reimbType) {
		super();
		this.reimbAuthorId = reimbAuthorId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbType = reimbType;
	}



	public ReimbursementDTO(int id, String reimbStatus, int reimbAuthorId, double reimbAmount, String reimbDescription,
			String reimbType) {
		super();
		this.id = id;
		this.reimbStatus = reimbStatus;
		this.reimbAuthorId = reimbAuthorId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbType = reimbType;
	}



	@Override
	public String toString() {
		return "ReimbursementDTO [id=" + id + ", reimbStatus=" + reimbStatus + ", reimbAuthorId=" + reimbAuthorId
				+ ", reimbAmount=" + reimbAmount + ", reimbDescription=" + reimbDescription + ", reimbType=" + reimbType
				+ "]";
	}



	public int getReimbResolverId() {
		return reimbResolverId;
	}



	public void setReimbResolverId(int reimbResolverId) {
		this.reimbResolverId = reimbResolverId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getReimbStatus() {
		return reimbStatus;
	}



	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}



	public int getReimbAuthorId() {
		return reimbAuthorId;
	}



	public void setReimbAuthorId(int reimbAuthorId) {
		this.reimbAuthorId = reimbAuthorId;
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



	public String getReimbType() {
		return reimbType;
	}



	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbAuthorId;
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
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
		ReimbursementDTO other = (ReimbursementDTO) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthorId != other.reimbAuthorId)
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		return true;
	}
	
	





	
	
}
