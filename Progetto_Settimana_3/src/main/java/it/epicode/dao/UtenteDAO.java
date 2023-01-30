package it.epicode.dao;

import it.epicode.utils.JpaUtil;

public class UtenteDAO {
	public static void addElement(Object o) {
		try {
			JpaUtil.t.begin();
			JpaUtil.em.persist(o);
			JpaUtil.t.commit();

			System.out.println("Utente aggiunto correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Impossibile aggiungere! " + e);
		}
	}
}
