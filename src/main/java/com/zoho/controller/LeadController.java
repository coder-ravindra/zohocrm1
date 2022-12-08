package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contact;
import com.zoho.entities.Lead;
import com.zoho.services.ContactService;
import com.zoho.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@Autowired
	private ContactService contactService;

	//http://localhost:7070/create
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String viewCreateLeadFrom() {
		return "create_lead";
		
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveOneLead(@ModelAttribute("lead")Lead lead,Model model) {
		leadservice.saveLeadInformation(lead);
		model.addAttribute("lead",lead);
		model.addAttribute("msg","Lead is save");
		
		return "Info";
		
	}
	//http://localhost:7070/listleads
	
	@RequestMapping("/listleads")
	public String listLead(Model model) {
		List<Lead> leads = leadservice.getAllLeads();
		model.addAttribute("leads",leads);
		
		return "list_leads";
		
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id")Long id, Model model) {
		Lead lead =leadservice.findLeadbyId(id);
		model.addAttribute("lead", lead);
		return "Info";
	}
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id")long id,Model model) {
		Lead lead=leadservice.findLeadbyId(id);
		Contact contact=new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveContactInformation(contact);
		
		leadservice.deleteOneLead(id);
		
		
		
		
		List<Contact> Contacts = contactService.getAllContact();
		model.addAttribute("Contacts", Contacts);
		
		return "list_contacts";
	}

}
