package com.example.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.entity.Appuntamento;
import com.example.agenda.entity.Ufficio;

public interface UfficioRepository extends JpaRepository<Ufficio, Long>  {

}
