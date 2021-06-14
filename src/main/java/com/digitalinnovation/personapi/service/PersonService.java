package com.digitalinnovation.personapi.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.personapi.controller.dto.response.MessageResponseDTO;
import com.digitalinnovation.personapi.dto.PersonDTO;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.mapper.PersonMapper;
import com.digitalinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
	}
}
