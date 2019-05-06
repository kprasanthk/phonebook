package com.pk.phonebook.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pk.phonebook.model.PersonPhones;
import com.pk.phonebook.model.PhoneDetails;

@Repository
public class PhoneBookDAO {
	
	private static Map<String, List<PhoneDetails>> NAME2PHONES = new HashMap<String, List<PhoneDetails>>();
	private static Map<String, String> PHONE2NAME = new HashMap<String, String>();
	
	//test data
	static {
		List<PhoneDetails> l1 = new ArrayList<PhoneDetails>();
		l1.add(new PhoneDetails("7459719239","Active"));
		l1.add(new PhoneDetails("9742703692","Inactive"));
		NAME2PHONES.put("prasanth", l1);
		PHONE2NAME.put("7459719239", "prasanth");
		PHONE2NAME.put("9742703692", "prasanth");
		
		List<PhoneDetails> l2 = new ArrayList<PhoneDetails>();
		l2.add(new PhoneDetails("7559719240","Inactive"));
		l2.add(new PhoneDetails("7563423980","Inactive"));
		NAME2PHONES.put("john", l2);
		PHONE2NAME.put("7559719240", "john");
		PHONE2NAME.put("7563423980", "john");
		
		List<PhoneDetails> l3 = new ArrayList<PhoneDetails>();
		l3.add(new PhoneDetails("7654578257","Inactive"));
		NAME2PHONES.put("nick", l3);
		PHONE2NAME.put("7654578257", "nick");
	}
	
	public List<PersonPhones> getAllPhoneNumbers() {
		List<PersonPhones> allPhones = new ArrayList<PersonPhones>();
		for(String name : NAME2PHONES.keySet()) {
			PersonPhones pp = new PersonPhones();
			pp.setName(name);
			pp.setPhones(NAME2PHONES.get(name));
			allPhones.add(pp);
		}
		return allPhones;
	}
	
	public PersonPhones getPhoneNumbersByPerson(String name) {
		PersonPhones pp = new PersonPhones();
		if(NAME2PHONES.get(name)!=null) {
			pp.setPhones(NAME2PHONES.get(name));
			pp.setName(name);
		}
		return pp;
	}
	
	public String activatePhoneByNumber(String number) {
		String name = PHONE2NAME.get(number);
		List<PhoneDetails> phns = NAME2PHONES.get(name);
		if(phns!=null && !phns.isEmpty()) {
			for(PhoneDetails pd : phns) {
				if(pd.getPhoneNumber().equals(number)) {
					if(!"Active".equalsIgnoreCase(pd.getStatus())) {
						pd.setStatus("Active");
						return "success";
					}else {
						return "phone is already active";
					}
				}
			}
		}
		return "phone number not found";
	}

}
