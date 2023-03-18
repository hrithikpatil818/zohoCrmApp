package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contacts;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactsService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactsService contactservice;
	
	@Autowired
	private BillingService billingservice;
	
	@RequestMapping("/listContacts")
	public String listAllContacts(Model model) {
		List<Contacts> contacts = contactservice.getAllContacts();
		model.addAttribute("contacts", contacts);
		return"list_contacts";
	}
	
	@RequestMapping("/createBill")
	public String createBill(@RequestParam("id")long id, Model model) {
		Contacts contact = contactservice.getContactByid(id);
		model.addAttribute("contact", contact);
		return"generate_Bill";
	}
	
	@RequestMapping("/saveBill")
	public String saveBill(Billing bill) {
		billingservice.genrateBill(bill);
		return"list_Bills";
		
	}

}
