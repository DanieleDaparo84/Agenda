package com.example.agenda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.agenda.entity.Ufficio;

@Service
public interface UfficioService {
         List<Ufficio> getAllUffici();
	     
	     Ufficio saveUfficio(Ufficio ufficio);
	     
	     Ufficio getUfficioById(Long id);
	     
	     Ufficio updateUfficio(Ufficio ufficio);
	     
	     void  deleteUfficioById(Long id);
	     
	     
}
