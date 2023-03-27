package com.example.agenda.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.agenda.entity.Ufficio;
import com.example.agenda.repository.AppuntamentoRepository;
import com.example.agenda.repository.UfficioRepository;
import com.example.agenda.service.UfficioService;



@Service
public class UfficioServiceImpl implements UfficioService  {

			private UfficioRepository ufficioRepository;
			
			public UfficioServiceImpl(UfficioRepository ufficioRepository) {
				super();
		 		this.ufficioRepository = ufficioRepository;
			}

			@Override
			public List<Ufficio> getAllUffici() {
				return ufficioRepository.findAll();
			
		}
			 @Override
				public Ufficio saveUfficio(Ufficio ufficio) {
					return ufficioRepository.save(ufficio);
				}

			@Override
			public Ufficio getUfficioById(Long id) {
				return ufficioRepository.findById(id).get();
			}

			@Override
			public Ufficio updateUfficio(Ufficio ufficio) {
				return ufficioRepository.save(ufficio);
			}

			@Override
			public void deleteUfficioById(Long id) {
				ufficioRepository.deleteById(id);
				
			}

		
		
		}

