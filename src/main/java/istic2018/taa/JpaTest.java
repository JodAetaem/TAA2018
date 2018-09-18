package istic2018.taa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import endpoints.RestApplication;
import entity.Lieu;
import entity.LieuId;
import entity.Region;
import entity.Sport;
import entity.Sportexterieur;
import entity.Sportinterieur;
import io.undertow.Undertow;
import repository.ILieuDAO;
import repository.IRegionDAO;
import repository.ISportDAO;
import repository.LieuDAO;
import repository.RegionDAO;
import repository.SportDAO;

public class JpaTest {
	
    private static final Logger logger = Logger.getLogger(RestApplication.class.getName());


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
		
    
		manager.close();
		
		   UndertowJaxrsServer ut = new UndertowJaxrsServer();
		   RestApplication app = new RestApplication();
		   ut.deploy(app);

	        ut.start(
	                Undertow.builder()
	                        .addHttpListener(3030, "localhost")

	        );

	        logger.info("JAX-RS based micro-service running!");

	}

}
