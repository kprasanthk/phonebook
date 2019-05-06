package com.pk.phonebook.model;

public class PhoneDetails {

	private String phoneNumber;
	private String status;
	
	public PhoneDetails() {
		
	}
	public PhoneDetails(String phoneNumber, String status) {
		this.phoneNumber=phoneNumber;
		this.status=status;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
