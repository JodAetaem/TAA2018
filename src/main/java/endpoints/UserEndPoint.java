package endpoints;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import istic2018.taa.EntityManagerHelper;
import repository.IUserDAO;
import repository.UserDAO;

@Path("/user")
@Api(value="User resource")
public class UserEndPoint {

	private static final Logger logger = Logger.getLogger(UserEndPoint.class.getName());
	
	EntityManager manager = EntityManagerHelper.getEntityManager();

	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Find user by id")
	public User getUserById(@PathParam("id") long id) {
		User u = new User();
		IUserDAO<User,Long> userDAO = new UserDAO(manager,User.class);

		u = userDAO.findByPrimaryKey(id);
		logger.warning("coucou!!\n\n");

		return u;
	}

	@GET
	@Path("/pseudo/{pseudo}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByPseudo(@PathParam("pseudo") String pseudo) {
		User u = new User();
		IUserDAO<User,Long> userDAO = new UserDAO(manager,User.class);

		u = userDAO.findByPseudo(pseudo);
		logger.warning("coucou!!\n\n");
		return u;
	}
	
	@POST
	@Consumes("application/json")
	public Response addUser(User user){
		
		IUserDAO<User, Long> userDAO = new UserDAO(manager, User.class);
		userDAO.create(user);
		
		return Response.noContent().build();
	}

}
