package it.epicode.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articolo_di_lettura")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "articolo_type", discriminatorType = DiscriminatorType.STRING)
public abstract class ArticoloDiLettura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	protected String isbn;
	protected String titolo;
	@Column(name="anno_pubblicazione")
	protected int annoPubblicazione;
	@Column(name="numero_pagine")
	protected int numeroPagine;
	
	public ArticoloDiLettura(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}
}
