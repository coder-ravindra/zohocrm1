package com.zoho.services;

import java.util.List;

import com.zoho.entities.Contact;

public interface ContactService {
	public void saveContactInformation(Contact contasts);
	public List<Contact> getAllContact();
	public Contact findContactbyId(long id);

}
