package com.caleb.umlestudodecaso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caleb.umlestudodecaso.domain.Client;
import com.caleb.umlestudodecaso.repositories.ClientRepository;
import com.caleb.umlestudodecaso.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client find(Integer id) {
		Optional<Client> object = clientRepository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", kind: " + Client.class.getName()));
	}
}
