package com.example.agenda.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appuntamenti")
public class Appuntamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "tipologia")
	private String tipologia;

	@Column(name = "ufficio")
	private String ufficio;

	@ManyToOne(optional = true)
	@JoinColumn(name = "ufficio_scelto")
	private Ufficio ufficiomto;

	public Ufficio getUfficiomto() {
		return ufficiomto;
	}

	public void setUfficiomto(Ufficio ufficio) {
		this.ufficiomto = ufficio;
	}

	public Appuntamento() {

	}

	public Appuntamento(Date data, String descrizione, String tipologia, String ufficio) {
		super();
		this.data = data;
		this.descrizione = descrizione;
		this.tipologia = tipologia;
		this.ufficio = ufficio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getUfficio() {
		return ufficio;
	}

	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

}
