package it.epicode.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("libro")
@NamedQuery(name = "removeByIsbn", query = "DELETE Libro l WHERE l.isbn = :n")
@NamedQuery(name = "getByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :n")
@NamedQuery(name = "getByAutore", query = "SELECT l FROM Libro l WHERE l.autore = :n")
@NamedQuery(name = "getByTitolo", query = "SELECT l FROM Libro l WHERE l.titolo LIKE :n")
@NamedQuery(name = "getByAnno", query = "SELECT l FROM Libro l WHERE l.annoPubblicazione = :n")
public class Libro extends ArticoloDiLettura{
    // ----------------------PROPRIETA--------------------------	
	
	private String autore;
	private String genere;
	
    // ----------------------- COSTRUTTORE ---------------------
	
	public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);

		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + " titolo=" + getTitolo() + "]";
	}
	
	
}
