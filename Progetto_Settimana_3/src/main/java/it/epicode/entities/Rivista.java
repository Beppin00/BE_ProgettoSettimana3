package it.epicode.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rivista")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("libro")
public class Rivista extends ArticoloDiLettura{
	// ----------------------PROPRIETA--------------------------
		@Enumerated(EnumType.STRING)
		private Periodicita periodicita;


		
		// ----------------------- COSTRUTTORE ---------------------

		public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
			super(isbn, titolo, annoPubblicazione, numeroPagine);

			this.periodicita = periodicita;
		}
}
