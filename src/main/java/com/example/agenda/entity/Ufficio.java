package com.example.agenda.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "uffici")
public class Ufficio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable=true)
	private String nome;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	
	// private Appuntamento Set<Appuntamento> appuntamenti;
	
	public Ufficio() {
		}
	
	public Ufficio(String nome, String indirizzo) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
   }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
//	   @OneToMany( 
//	              mappedBy = "ufficio" )
//      private Set<Appuntamento> appuntamenti;
//	    public Set<Appuntamento> getAppuntamenti() {
//	        return appuntamenti;
//	    }
//	    public void setAppuntamenti(Set<Appuntamento> appuntamenti) {
//	        this.appuntamenti = appuntamenti;
//	    }
	
}
