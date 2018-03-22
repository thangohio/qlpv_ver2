package model.bean;

import java.util.Date;

public class User {

	private String id;
	private String fullName;
	private Date dob;
	private boolean isMale;
	private String email;
	private String pwd;
	private String phoneNumber;
	private String privilege;
	
	public User(String id, String fullName, Date dob, boolean isMale, String email, String pwd, String phoneNumber,
			String privilege) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.isMale = isMale;
		this.email = email;
		this.pwd = pwd;
		this.phoneNumber = phoneNumber;
		this.privilege = privilege;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullNmae(String fullNmae) {
		this.fullName = fullNmae;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	
}
