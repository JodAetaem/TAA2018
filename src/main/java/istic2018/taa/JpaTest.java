package istic2018.taa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Sport;
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
		
	
		Sport sport = new Sport();
		sport.setLabel("sport1");
		ISportDAO<Sport,Long> sportDAO = new SportDAO(manager);
		sportDAO. create(sport);
		manager.close();
	}

}
