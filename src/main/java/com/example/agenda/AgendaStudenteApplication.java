package com.example.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.agenda.entity.Appuntamento;
import com.example.agenda.repository.AppuntamentoRepository;
import com.example.agenda.repository.UfficioRepository;

@SpringBootApplication
public class AgendaStudenteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AgendaStudenteApplication.class, args);
		}
	
        @Autowired
		private AppuntamentoRepository appuntamentoRepository;
        
        @Autowired
		private UfficioRepository ufficioRepository;

		@Override
		public void run(String... args) throws Exception {

	}

}
