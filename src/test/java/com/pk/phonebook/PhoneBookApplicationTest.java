package com.pk.phonebook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pk.phonebook.model.PersonPhones;
import com.pk.phonebook.service.PhoneBookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneBookApplicationTest {

	@Autowired
	private PhoneBookService phoneBookService;
	
	@Test
	public void testGetAllPhoneNumbers() {
		List<PersonPhones> allPhones = phoneBookService.getAllPhoneNumbers();
		assertThat(allPhones).isNotEmpty();
		assertThat(allPhones.get(0).getPhones()).isNotEmpty();
	}
	
	@Test
	public void testGetPhoneNumbersByName() {
		PersonPhones phones = phoneBookService.getPhoneNumbersByPerson("prasanth");
		assertThat(phones.getName()).isEqualTo("prasanth");
		assertThat(phones.getPhones()).isNotEmpty();
	}
	
	@Test
	public void testGetPhoneNumbersByNameWhenNameNotExistInPhoneBook() {
		PersonPhones phones = phoneBookService.getPhoneNumbersByPerson("david");
		assertThat(phones.getName()).isNull();
		assertThat(phones.getPhones()).isNull();
	}
	
	@Test
	public void testActivatePhoneNumber() {
		String status = phoneBookService.activatePhone("9742703692");
		assertThat(status).isEqualTo("success");
	}
	
	@Test
	public void testActivatePhoneNumberWhenPhoneisAlreadyActive() {
		String status = phoneBookService.activatePhone("7459719239");
		assertThat(status).isEqualTo("phone is already active");
	}
	
	@Test
	public void testActivatePhoneNumberWhenPhoneisInvalid() {
		String status = phoneBookService.activatePhone("1234567891");
		assertThat(status).isEqualTo("phone number not found");
	}
}
