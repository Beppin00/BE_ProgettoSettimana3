package it.epicode.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestito")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery (name = "prestitoBytessera", query = "SELECT p FROM Prestito p where p.utente.numeroTessera = :nt")
//@NamedQuery (name = "prestitiScaduti", query = "SELECT p FROM Prestito p WHERE (restituzionePrevista > CURRENT DATE AND restituzioneEffettiva IS NULL)")
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name = "libro_id", referencedColumnName = "id")
	private ArticoloDiLettura elementoPrestato;
	
	@Column(name = "inizio_prestito")
	private LocalDate dataInizioPrestito;
	
	@Column(name = "restituzione_prevista")
	private LocalDate restituzionePrevista;
	
	@Column(name = "restituzione_effettiva")
	private LocalDate restituzioneEffettiva;
	
}
