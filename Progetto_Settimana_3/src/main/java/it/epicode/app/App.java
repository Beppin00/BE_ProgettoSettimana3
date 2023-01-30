package it.epicode.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.epicode.dao.LibroDAO;
import it.epicode.dao.PrestitoDAO;
import it.epicode.dao.RivistaDAO;
import it.epicode.dao.UtenteDAO;
import it.epicode.entities.Libro;
import it.epicode.entities.Periodicita;
import it.epicode.entities.Prestito;
import it.epicode.entities.Rivista;
import it.epicode.entities.Utente;

public class App {

	private static List<Libro> listLibro = new ArrayList<Libro>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//------------LIBRO------------
		Libro l = new Libro();
		l.setAutore("Pippo");
		l.setGenere("fantasy");
		l.setIsbn("l1");
		l.setNumeroPagine(100);
		l.setTitolo("titolo1");
		l.setAnnoPubblicazione(2020);
		
		//LibroDAO.addElement(l);
		
		//------------RIVISTA------------
		Rivista r = new Rivista();
		r.setTitolo("rivista");
		r.setIsbn("r1");
		r.setAnnoPubblicazione(2021);
		r.setNumeroPagine(100);
		r.setPeriodicita(Periodicita.mensile);
		
		//RivistaDAO.addElement(r);
		
		//------------UTENTE------------
		Utente u = new Utente();
		u.setNome("Giuseppe");
		u.setCognome("Cascone");
		u.setDataDiNascita(LocalDate.parse("1994-12-01"));
		u.setNumeroTessera(100);
		
		//UtenteDAO.addElement(u);
		
		//------------PRESTITO------------
		Prestito p = new Prestito();
		p.setElementoPrestato(l);
		p.setDataInizioPrestito(LocalDate.parse("2023-01-20"));
		p.setUtente(u);
		p.setRestituzioneEffettiva(LocalDate.parse("2023-03-20"));
		p.setRestituzionePrevista(LocalDate.parse("2023-02-20"));
		
		
		//PrestitoDAO.addElement(p);
		
		
		
		//UtenteDAO.addElement(u);
		
		//LibroDAO.removeByIsbn("l1");
		
		//LibroDAO.getByIsbn("l1");
		
		//LibroDAO.getByAnno(2020);
		
		
		//listLibro = LibroDAO.getByAnno(2020);
		//listLibro.forEach(c -> System.out.println(c.toString()));
		
		
		
		
		PrestitoDAO.getByTessera(100);
		
		PrestitoDAO.getPrestitiScaduti();
	}

}
