package com.example.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.agenda.entity.Appuntamento;
import com.example.agenda.repository.AppuntamentoRepository;
import com.example.agenda.service.AppuntamentoService;

@Service
public class AppuntamentoServiceImpl implements AppuntamentoService {

	private AppuntamentoRepository appuntamentoRepository;

	public AppuntamentoServiceImpl(AppuntamentoRepository appuntamentoRepository) {
		super();
		this.appuntamentoRepository = appuntamentoRepository;
	}

	@Override
	public List<Appuntamento> getAllAppuntamenti() {
		return appuntamentoRepository.findAll();

	}

	@Override
	public Appuntamento saveAppuntamento(Appuntamento appuntamento) {
		if(appuntamento.getData() != null) {
		List<Appuntamento> controlloApp = appuntamentoRepository.findByDataAndUfficio(appuntamento.getData(),
				appuntamento.getUfficio());
		if (controlloApp == null || controlloApp.size() < 1)
			return appuntamentoRepository.save(appuntamento);
		else
			return null;
		}
		return null;
	}

	@Override
	public Appuntamento getAppuntamentoById(Long id) {
		return appuntamentoRepository.findById(id).get();
	}

	@Override
	public Appuntamento updateAppuntamento(Appuntamento appuntamento) {
		return appuntamentoRepository.save(appuntamento);
	}

	@Override
	public void deleteAppuntamentoById(Long id) {
		appuntamentoRepository.deleteById(id);

	}

	@Override
	public List<Appuntamento> findByTipologiaContainingIgnoreCase(String tipologia) {

		return appuntamentoRepository.findByTipologiaContainingIgnoreCase(tipologia);
	}

	@Override
	public Optional<Appuntamento> findById(Long id) {
		
		return appuntamentoRepository.findById(id);
	}

}
