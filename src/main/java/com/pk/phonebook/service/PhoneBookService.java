package com.pk.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.phonebook.dao.PhoneBookDAO;
import com.pk.phonebook.model.PersonPhones;

@Service
public class PhoneBookService {

	@Autowired
	private PhoneBookDAO phoneBookDAO;
	
	public List<PersonPhones> getAllPhoneNumbers() {
		return phoneBookDAO.getAllPhoneNumbers();
	}
	
	public PersonPhones getPhoneNumbersByPerson(String name) {
		return phoneBookDAO.getPhoneNumbersByPerson(name);
	}
	
	public String activatePhone(String number) {
		return phoneBookDAO.activatePhoneByNumber(number);
	}
	
}
