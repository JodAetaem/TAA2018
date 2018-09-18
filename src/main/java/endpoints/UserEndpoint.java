package endpoints;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entity.Sport;
import entity.User;
import istic2018.taa.EntityManagerHelper;
import repository.ISportDAO;
import repository.IUserDAO;
import repository.SportDAO;
import repository.UserDAO;

@Path("/user")
public class UserEndpoint {
	
    private static final Logger logger = Logger.getLogger(UserEndpoint.class.getName());
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") long id) {
    	User u = new User();
    	IUserDAO<User,Long> userDAO = new UserDAO(manager,User.class);
    	
    	u = userDAO.findByPrimaryKey(id);
    	
    	return u;
    }

}
