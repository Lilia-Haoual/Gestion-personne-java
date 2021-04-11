package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Personne;



public interface PersonneService {
	//List<Personne> getAllPersonne();
	//void savePersonne(Personne personne);
	//Personne updatePersonne(Long id);
	List<Personne>getAllPersonne();
	void savePersonne(Personne personne);
	Personne getPersonneById(long id);
	Personne updatePersonne(long id);
	void deletePersonne(long id);
	List<Personne> orderByPrenom();
	void orderByNom(String nom);
	void orderByEmail(String email);
	void filterByDepartement(String departement);
}
