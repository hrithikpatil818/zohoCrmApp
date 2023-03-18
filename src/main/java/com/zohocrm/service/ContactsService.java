package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Contacts;

public interface ContactsService {
							//entity class object								
	public void saveContact(Contacts contacts);

	public List<Contacts> getAllContacts();

	public Contacts getContactByid(long id);

	

}
