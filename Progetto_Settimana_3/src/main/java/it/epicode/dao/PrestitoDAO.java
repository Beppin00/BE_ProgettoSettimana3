package it.epicode.dao;


import java.util.List;

import javax.persistence.Query;

import it.epicode.entities.Prestito;
import it.epicode.utils.JpaUtil;

public class PrestitoDAO {
	public static void addElement(Prestito o) {
		try {
			JpaUtil.t.begin();
			JpaUtil.em.persist(o);
			JpaUtil.t.commit();;

			System.out.println("Prestito aggiunto correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Impossibile aggiungere! " + e);
		}
	}
	
	public static void getByTessera(int tessera) {
		JpaUtil.t.begin();
		
		
		try {
			Query q = JpaUtil.em.createNamedQuery("prestitoBytessera");
			q.setParameter("nt", tessera);
			
			List<Prestito> res = q.getResultList();
			
			for(Prestito l : res) {
				System.out.println(l);
			}
			
			System.out.println("Prestito trovato correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRORE nella rimozione!");
		}
	}
	
	public static void getPrestitiScaduti() {
		JpaUtil.t.begin();
		
		
		try {
			Query q = JpaUtil.em.createNamedQuery("prestitoBytessera");
			
			List<Prestito> res = q.getResultList();
			
			for(Prestito l : res) {
				System.out.println(l);
			}
			
			System.out.println("Prestiti scaduti trovati correttamente!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERRORE nella rimozione!");
		}
	}
}
