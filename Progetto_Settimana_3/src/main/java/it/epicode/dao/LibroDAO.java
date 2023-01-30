package it.epicode.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import it.epicode.entities.Libro;
import it.epicode.utils.JpaUtil;

public class LibroDAO {
	public static void addElement(Object o) {
		try {
			JpaUtil.t.begin();
			JpaUtil.em.persist(o);
			JpaUtil.t.commit();

			System.out.println("Evento aggiunto correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Impossibile aggiungere! " + e);
		}
	}

	public static void removeByIsbn(String isbn) {
		JpaUtil.t.begin();

		try {
			Query q = JpaUtil.em.createNamedQuery("removeByIsbn");
			q.setParameter("n", isbn);
			int delete = q.executeUpdate();
			JpaUtil.em.getTransaction();
			JpaUtil.t.commit();

			System.out.println("Libro rimosso correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRORE nella rimozione!");
		}
	}

	public static void getByIsbn(String isbn) {

		try {
			Query q = JpaUtil.em.createNamedQuery("getByIsbn");
			q.setParameter("n", isbn);

			List<Libro> res = q.getResultList();

			for (Libro l : res) {
				System.out.println(l.toString());
			}

			System.out.println("Libro rimosso correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRORE nella rimozione!");
		}
	}

	public static List<Libro> getByAnno(int anno) {
		try {
			Query q = JpaUtil.em.createNamedQuery("getByAnno");
			q.setParameter("n", anno);
			
			return q.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}


	public static void getByAutore(String autore) {

		try {
			Query q = JpaUtil.em.createNamedQuery("getByAutore");
			q.setParameter("n", autore);

			List<Libro> res = q.getResultList();

			for (Libro l : res) {
				System.out.println(l.toString());
			}

			System.out.println("Libro trovato!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRORE nella rimozione!");
		}
	}

	public static void getByTitolo(String titolo) {

		try {
			Query q = JpaUtil.em.createNamedQuery("getByTitolo");
			q.setParameter("n", "%" + titolo + "%");

			List<Libro> res = q.getResultList();

			for (Libro l : res) {
				// non stampa il to string
				System.out.println(l.toString());
			}

			System.out.println("Libro trovato!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRORE nella rimozione!");
		}
	}
}
