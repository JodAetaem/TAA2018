package endpoints;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.User;
import istic2018.taa.EntityManagerHelper;
import repository.IUserDAO;
import repository.UserDAO;

@Path("/user")
public class UserEndPoint {

	private static final Logger logger = Logger.getLogger(UserEndPoint.class.getName());
	
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") long id) {
		User u = new User();
		IUserDAO<User,Long> userDAO = new UserDAO(manager,User.class);

		u = userDAO.findByPrimaryKey(id);
		logger.warning("coucou!!\n\n");

		return u;
	}
/*
	@GET
	@Path("{pseudo}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByPseudo(@PathParam("pseudo") String pseudo) {
		User u = new User();
		IUserDAO<User,Long> userDAO = new UserDAO(manager,User.class);

		u = userDAO.findByPseudo(pseudo);
		logger.warning("coucou!!\n\n");
		return u;
	}*/

}
