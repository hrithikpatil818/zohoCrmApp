package com.zohocrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm.entities.Contacts;
//import com.zohocrm.entities.Lead;

public interface ContactsRepository2 extends JpaRepository<Contacts, Long> {

}
