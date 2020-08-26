package com.lti.entity;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;


@Entity
public class Admin {
	
	@Id
	@GeneratedValue
	@Column(name="AID",length=10)
	private int adminId;
	
	@Column(name="APASS",length=20)
	private String adminPassword;
	
	@Column(name="ANAME",length=20)
	private String adminName;
	
	@Column(name="AEMAIL",length=30)
	private String adminEmail;
	
	@Column(name="APHONE",length=10)
	private String adminPhoneNo;

	
	
	public Admin(int adminId, String adminPassword, String adminName, String adminEmail, String adminPhoneNo) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPhoneNo = adminPhoneNo;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPhoneNo() {
		return adminPhoneNo;
	}

	public void setAdminPhoneNo(String adminPhoneNo) {
		this.adminPhoneNo = adminPhoneNo;
	}


}
