package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Personne;
import com.example.demo.repository.PersonneRepository;


@Service
@Transactional
public class PersonneServiceImpl implements PersonneService{
	@Autowired
	private  PersonneRepository personneRepository;

	@Override
	public List<Personne> getAllPersonne() {
		List<Personne> personnes=personneRepository.findAll();
		return personnes;
	}

	/*@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}*/
	
	@Override
	public void savePersonne(Personne personne) {
		this.personneRepository.save(personne);
		
	}

	
	
	@Override
	public Personne updatePersonne(long id) {
		Optional<Personne> optional= personneRepository.findById(id);
		Personne personne=null;
		if(optional.isPresent()) {
			personne=optional.get();
		}else {
			throw new RuntimeException("Personne not found for id"+id);
		}
		return personne;
	}
	
	

	@Override
	public void deletePersonne(long id) {
		this.personneRepository.deleteById(id);
		
	}

	@Override
	public List<Personne> orderByPrenom() {
		List<Personne>personnes=personneRepository.findAll(Sort.by(Sort.Direction.ASC));
		return personnes;
	}

	@Override
	public void orderByNom(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filterByDepartement(String departement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personne getPersonneById(long id) {
		Optional<Personne> optional= personneRepository.findById(id);
		Personne personne =null;
		if(optional.isPresent()) {
			personne= optional.get();
		}else {
			throw new RuntimeException("Employee not found for id:"+id);
		}
		return personne;
	}

}
