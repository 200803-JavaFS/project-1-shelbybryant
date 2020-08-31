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
@Table(name="user_roles")
public class UserRoles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_role_id")
	private int userRoleId;
	@Column(name="user_role")
	private String userRole;
	@OneToMany(mappedBy="userRoleId", fetch=FetchType.EAGER)
	private List<UserRoles> urList;
	
	
	
	public UserRoles() {
		super();
		
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserRoles [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
}
