package istic2018.taa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Sport;
import entity.Sportexterieur;
import entity.Sportinterieur;
import repository.ISportDAO;
import repository.SportDAO;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		EntityManager manager = EntityManagerHelper.getEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
	
		Sportinterieur sporti = new Sportinterieur();
		sporti.setLabel("sportinterieur");
		ISportDAO<Sport,Long> sportDAO = new SportDAO(manager);
		sportDAO. create(sporti);
		
		Sportexterieur sporte = new Sportexterieur();
		sporte.setLabel("sportexterieur");
		ISportDAO<Sport,Long> sportDAO2 = new SportDAO(manager);
		sportDAO2. create(sporte);
		manager.close();
	}

}
