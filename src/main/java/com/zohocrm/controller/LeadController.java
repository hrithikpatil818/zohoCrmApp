package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contacts;
import com.zohocrm.entities.Lead;
import com.zohocrm.service.ContactsService;
import com.zohocrm.service.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	
	@Autowired
	private ContactsService contactservice;
	
	
	// http://localhost:8080/createLead
	@RequestMapping(value = "/createLead", method = RequestMethod.GET) //through URL
	public String viewCreateLeadForm() {
		
		return"create_lead";
	}
	
	
	@RequestMapping(value = "/saveLead" , method = RequestMethod.POST) //through Form
	public String saveLead(@ModelAttribute("lead") Lead lead , Model model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
	
	@RequestMapping( "/convertLead")
	public String convertLead(@RequestParam("id")long id, Model model) {
		Lead lead = leadService.getLeadById(id);
		
		
		Contacts contacts = new Contacts();
		contacts.setFirstName(lead.getFirstName());
		contacts.setLastName(lead.getLastName());
		contacts.setEmail(lead.getEmail());
		contacts.setMobile(lead.getMobile());
		contacts.setMobile(lead.getMobile());
		contacts.setSource(lead.getSource());
		
		contactservice.saveContact(contacts);
		
		leadService.deleteLeadById(id);
		
		List<Contacts> allContacts = contactservice.getAllContacts();
		model.addAttribute("allContacts", allContacts);
		return "list_contacts";
	}
	
	@RequestMapping("/listLeads")
	public String listAllLeads(Model model) {
		
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return"list_Leads";
		
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id")long id, Model model) {
		
		Lead lead = leadService.getLeadById(id);
		model.addAttribute("lead", lead);
		return"lead_info";
		
		
		
		
	}
	

	
	
	

}
