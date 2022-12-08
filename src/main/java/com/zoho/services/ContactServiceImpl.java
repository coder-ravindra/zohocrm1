package com.zoho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Contact;
import com.zoho.entities.Lead;
import com.zoho.repositories.ContactRepository;
import com.zoho.repositories.LeadRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void saveContactInformation(Contact contact) {
		contactRepo.save(contact);
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> leads = contactRepo.findAll();
		
		return leads;
	}

	@Override
	public Contact findContactbyId(long id) {
      Optional<Contact> findById = contactRepo.findById(id);
      Contact contact = findById.get();
		return contact;
	}

}
