package com.zohocrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Contacts;
import com.zohocrm.repository.ContactsRepository2;

@Service
public class ContactsServiceImpl implements ContactsService {

	@Autowired
	private ContactsRepository2 contactsRepo;
	
	@Override
	public void saveContact(Contacts contacts) {
		contactsRepo.save(contacts);

	}

	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactsRepo.findAll();
		return contacts;
	}

	@Override
	public Contacts getContactByid(long id) {
		Optional<Contacts> findById = contactsRepo.findById(id);
		Contacts contacts = findById.get();
		return contacts;
	}

}
