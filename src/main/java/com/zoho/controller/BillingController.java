package com.zoho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Billing;
import com.zoho.entities.Contact;
import com.zoho.services.BillingService;
import com.zoho.services.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	
	@RequestMapping("/billingForm")
	public String viewBillingForm(@RequestParam("contactid")long id,Model model) {
		Contact contact = contactService.findContactbyId(id);
		model.addAttribute("contact", contact);
		return "create_bill";
	}
	
	@RequestMapping("/genratebill")
	public String genrateBill(@ModelAttribute("billing")Billing billing) {
		billingService.generateInvoice(billing);
		return "create_bill";
		
	}

}
