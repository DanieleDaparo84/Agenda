package com.example.agenda.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.agenda.entity.Appuntamento;
import com.example.agenda.service.AppuntamentoService;
import com.example.agenda.service.UfficioService;

@Controller
public class AppuntamentoController {

	private AppuntamentoService appuntamentoService;

	@Autowired
	private UfficioService ufficioService;

	public AppuntamentoController(AppuntamentoService appuntamentoService) {
		super();
		this.appuntamentoService = appuntamentoService;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/appuntamenti")
	public String listAppuntamenti(Model model, @RequestParam(required = false) String s,
			@RequestParam(required = false) Long id, @RequestParam(required = false) String numero) {
		List<Appuntamento> lApp = null;
		if (s != null && s.trim().length() > 0) {
			lApp = appuntamentoService.findByTipologiaContainingIgnoreCase(s.trim());
		} else if (id != null && id > 0) {
			Optional<Appuntamento> oap = appuntamentoService.findById(id);
			lApp = new ArrayList<Appuntamento>();
			if (oap.get() != null)
				lApp.add(oap.get());
		} else if (numero != null && numero.trim().length() > 0) {
			Long numeroLong = Long.decode(numero);
			Optional<Appuntamento> oap = appuntamentoService.findById(numeroLong);
			lApp = new ArrayList<Appuntamento>();
			if (oap.get() != null)
				lApp.add(oap.get());
		} else {
			lApp = appuntamentoService.getAllAppuntamenti();
		}

		model.addAttribute("appuntamenti", lApp);
		return "appuntamenti";

	}

	@GetMapping("/appuntamenti/new")
	public String createAppuntamentoForm(Model model) {

		// create new student object to hold student form data
		Appuntamento appuntamento = new Appuntamento();
		model.addAttribute("appuntamento", appuntamento);
		model.addAttribute("uffici", ufficioService.getAllUffici());
		return "create_appuntamento";

	}

	@PostMapping("/appuntamenti")
	public String saveAppuntamento(@ModelAttribute("appuntamento") Appuntamento appuntamento) {
		appuntamentoService.saveAppuntamento(appuntamento);
		return "redirect:/appuntamenti";
	}

	@GetMapping("/appuntamenti/edit/{id}")
	public String editAppuntamentoForm(@PathVariable Long id, Model model) {
		model.addAttribute("appuntamento", appuntamentoService.getAppuntamentoById(id));
		model.addAttribute("uffici", ufficioService.getAllUffici());
		return "edit_appuntamento";
	}

	@PostMapping("/appuntamenti/{id}")
	public String updateAppuntamento(@PathVariable Long id, @ModelAttribute("appuntamento") Appuntamento appuntamento,
			Model model) {

		// get student from database for id
		Appuntamento existingAppuntamento = appuntamentoService.getAppuntamentoById(id);
		existingAppuntamento.setId(id);
		existingAppuntamento.setData(appuntamento.getData());
		existingAppuntamento.setTipologia(appuntamento.getTipologia());
		existingAppuntamento.setDescrizione(appuntamento.getDescrizione());
		existingAppuntamento.setUfficio(appuntamento.getUfficio());
		existingAppuntamento.setUfficiomto(appuntamento.getUfficiomto());

		// save student object
		appuntamentoService.updateAppuntamento(existingAppuntamento);
		return "redirect:/appuntamenti";
	}

	// handler method to handle delete student request

	@GetMapping("/appuntamenti/{id}")
	public String deleteAppuntamento(@PathVariable Long id, Model model) {
		appuntamentoService.deleteAppuntamentoById(id);
		return "redirect:/appuntamenti";
	}

//	Appuntamento AppuntamentoByTipologiaAndDescrizione = appuntamentoService.findByTipologiaAndDescrizione("tipologia", "descrizione").get();
}
