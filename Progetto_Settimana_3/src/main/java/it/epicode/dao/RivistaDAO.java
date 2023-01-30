package it.epicode.dao;

import it.epicode.entities.Rivista;
import it.epicode.utils.JpaUtil;

public class RivistaDAO {
	public static void addElement(Rivista o) {
		try {
			JpaUtil.t.begin();
			JpaUtil.em.persist(o);
			JpaUtil.t.commit();

			System.out.println("Rivista aggiunto correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Impossibile aggiungere! " + e);
		}
	}
}
