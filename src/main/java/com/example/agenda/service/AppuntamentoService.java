package com.example.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.agenda.entity.Appuntamento;

@Service
public interface AppuntamentoService {
     List<Appuntamento> getAllAppuntamenti();
     
     List<Appuntamento> findByTipologiaContainingIgnoreCase(String tipologia);
     
     Optional<Appuntamento> findById(Long id);
     
     Appuntamento saveAppuntamento(Appuntamento appuntamento);
     
     Appuntamento getAppuntamentoById(Long id);
     
     Appuntamento updateAppuntamento(Appuntamento appuntamento);
     
     void  deleteAppuntamentoById(Long id);

//	Object findByTipologiaAndDescrizione(String string, String string2);
     
     
}



