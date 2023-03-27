package com.example.agenda.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.agenda.entity.Appuntamento;
import com.example.agenda.entity.Ufficio;
import com.example.agenda.service.UfficioService;

@Controller
public class UfficioController {

	private UfficioService ufficioService;
	
	public UfficioController(UfficioService ufficioService) {
		super();
		this.ufficioService = ufficioService;
	}
	
	// handler method to handle list students and return mode and view
		@GetMapping("/uffici")
		public String listUffici(Model model) {
			model.addAttribute("uffici", ufficioService.getAllUffici());
			return "uffici";

		}

		@GetMapping("/uffici/new")
		public String createUfficioForm(Model model) {

			// create new student object to hold student form data
			Ufficio ufficio = new Ufficio();
			model.addAttribute("ufficio", ufficio);
			return "create_ufficio";

		}

		@PostMapping("/uffici")
		public String saveUfficio(@ModelAttribute("ufficio") Ufficio ufficio) {
			ufficioService.saveUfficio(ufficio);
			return "redirect:/uffici";
		}

		@GetMapping("/uffici/edit/{id}")
		public String editUfficioForm(@PathVariable Long id, Model model) {
			model.addAttribute("ufficio", ufficioService.getUfficioById(id));
			return "edit_ufficio";
		}

		@PostMapping("/uffici/{id}")
		public String updateUfficio(@PathVariable Long id, @ModelAttribute("ufficio") Ufficio ufficio,
				Model model) {

			// get student from database for id
			Ufficio existingUfficio = ufficioService.getUfficioById(id);
			existingUfficio.setId(id);
			existingUfficio.setNome(ufficio.getNome());
			existingUfficio.setIndirizzo(ufficio.getIndirizzo());
			

			// save student object
			ufficioService.updateUfficio(existingUfficio);
			return "redirect:/uffici";
		}

		// handler method to handle delete student request

		@GetMapping("/uffici/{id}")
		public String deleteUfficio(@PathVariable Long id, Model model) {
			ufficioService.deleteUfficioById(id);
			return "redirect:/uffici";
		}

	}


