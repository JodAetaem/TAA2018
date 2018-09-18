package istic2018.taa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import endpoints.RestApplication;
import entity.Region;
import entity.Sport;
import repository.IRegionDAO;
import entity.Sportexterieur;
import entity.Sportinterieur;
import entity.User;
import io.swagger.jaxrs.config.BeanConfig;
import io.undertow.Undertow;
import repository.ILieuDAO;
import repository.IRegionDAO;
import repository.ISportDAO;
import repository.IUserDAO;
import repository.RegionDAO;
import repository.SportDAO;
import repository.UserDAO;

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
		
		IUserDAO<User,Long> userDAO = new UserDAO(manager, User.class);
		User user = new User();
		user.setEmail("djj");
		user.setPassword("pass");
		user.setPseudo("Boby");
		userDAO.create(user);
		
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
		sporte.setTemperatureMax(30);
		sporte.setTemperatureMin(15);
		sportDAO2. create(sporte);
		
		Region region = new Region();
		region.setCode(123);
		region.setName("Maregion");
		IRegionDAO<Region, Long> regionDao = new RegionDAO(manager, Region.class);
		regionDao.create(region);
		
		manager.close();
		
		   UndertowJaxrsServer server = new UndertowJaxrsServer();
	        server.deploy(new RestApplication());

	        BeanConfig beanConfig = new BeanConfig();
	        beanConfig.setVersion("0.0.0-alpha");
	        beanConfig.setSchemes(new String[]{"http"});
	        beanConfig.setHost("localhost:8081");
	        beanConfig.setBasePath("/");
	        beanConfig.setResourcePackage("endpoints");
	        beanConfig.setScan(true);
	        beanConfig.setPrettyPrint(true);

	server.start(Undertow.builder().addHttpListener(8081, "127.0.0.1"));
	        logger.info("JAX-RS based micro-service running!");

	}

}
