package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Personne;
import com.example.demo.service.PersonneService;



@Controller
public class PersonneControleur {
	
	@Autowired
	private PersonneService personneService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listPersonne",personneService.getAllPersonne() );
		return"index";
	}
	
	@GetMapping("/showNewPersonneForm")
	public String showNewPersonneForm(Model model) {
		Personne personne= new Personne();
		model.addAttribute("personne",personne);
		return "new_personne";
	}
	
	@PostMapping("/savePersonne")
	public String savePersonne(@ModelAttribute("personne") Personne personne) {
		personneService.savePersonne(personne);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id, Model model) {
		Personne personne= personneService.getPersonneById(id);
		System.out.println(personne);
		model.addAttribute("personne", personne);
		return "update_personne";
	}
	
	@GetMapping("/deletePersonne/{id}")
	public String deletePersonne(@PathVariable(value="id") long id) {
		this.personneService.deletePersonne(id);
		return "redirect:/"; // redirection vers la page d'acceuil "viewHomePage"
	}
	
	@GetMapping("/orderByPrenom")
	public String orderByPrenom(Model model) {
		model.addAttribute("listPersonne",personneService.orderByPrenom());
		return"index";
		
	}
	
	
}
