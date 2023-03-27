package com.example.agenda.repository;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.agenda.entity.Appuntamento;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Long>  {

             List<Appuntamento> findByData(Date data);	
             List<Appuntamento> findByDataAndUfficio(Date date, String Ufficio);
             List<Appuntamento> findByTipologiaContainingIgnoreCase(String tipologia);
             Optional<Appuntamento> findById(Long id);
             
		}



