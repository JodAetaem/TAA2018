package istic2018.taa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Lieu;
import entity.LieuId;
import entity.Region;
import entity.Sport;
import repository.ILieuDAO;
import repository.IRegionDAO;
import entity.Sportexterieur;
import entity.Sportinterieur;
import repository.ISportDAO;
import repository.LieuDAO;
import repository.RegionDAO;
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
		ISportDAO<Sport,Long> sportDAO = new SportDAO(manager,Sport.class);
		sportDAO. create(sport);
		Sportinterieur sporti = new Sportinterieur();
		sporti.setLabel("sportinterieur");
		sportDAO. create(sporti);
		
		Sportexterieur sporte = new Sportexterieur();
		sporte.setLabel("sportexterieur");
		ISportDAO<Sport,Long> sportDAO2 = new SportDAO(manager,Sport.class);
		sportDAO2. create(sporte);
		
		Region region = new Region();
		region.setCode(123);
		region.setName("Maregion");
		IRegionDAO<Region, Long> regionDao = new RegionDAO(manager, Region.class);
		regionDao.create(region);
		
		Lieu lieu = new Lieu();
		LieuId lid = new LieuId();
		lid.setCodePostal("35510");
		lid.setLabelVille("Cessong");
		lieu.setId(lid);
		ILieuDAO<Lieu, LieuId> lieuDAO = new LieuDAO<Lieu, LieuId>(manager, Lieu.class);
		lieuDAO.create(lieu);
		manager.close();

	}

}
