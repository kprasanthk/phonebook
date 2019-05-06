package com.pk.phonebook.model;

import java.util.List;

public class PersonPhones {
	private String name;
	private List<PhoneDetails> phones;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PhoneDetails> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDetails> phones) {
		this.phones = phones;
	}
	
}
