package model.bean;// test Github

import java.util.Date;

public class Customer {
	private String id;
	private String fullName;
	private Date dob;
	private boolean isMale;
	private String email;
	private String phoneNumber;
	private String personId;
	private String passport;
	
	public Customer(String id, String fullName, Date dob, boolean isMale, String email, String phoneNumber) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.isMale = isMale;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
}
