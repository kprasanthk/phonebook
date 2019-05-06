package com.pk.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pk.phonebook.model.PersonPhones;
import com.pk.phonebook.service.PhoneBookService;

@RestController
public class PhoneBookController {
	
	@Autowired
	private PhoneBookService phoneBookService;

	@RequestMapping(path="/allPhones", method=RequestMethod.GET)
	public List<PersonPhones> getAllPhonenumbers(){
		return phoneBookService.getAllPhoneNumbers();
	}
	
	@RequestMapping(path="/{name}/phones", method=RequestMethod.GET)
	public PersonPhones getPhonenumbersByName(@PathVariable String name){
		return phoneBookService.getPhoneNumbersByPerson(name);
	}
	
	@RequestMapping(path="/{phoneNum}/activate", method=RequestMethod.PUT)
	public String actiavatePhone(@PathVariable String phoneNum){
		return phoneBookService.activatePhone(phoneNum);
	}
	
}
