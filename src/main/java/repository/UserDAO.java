package repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import endpoints.RestApplication;
import entity.User;

public class UserDAO extends GenericDAO<User, Long> implements IUserDAO<User, Long> {

    private static final Logger logger = Logger.getLogger(RestApplication.class.getName());

	
	public UserDAO(EntityManager em, Class<User> classParameter) {
		super(em, classParameter);
	}

	public User findByPseudo(String pseudo) {
		try {
		 Query query = em.createQuery(
				 "SELECT u FROM User u WHERE u.pseudo = :pseudo");
		return (User) query.setParameter("pseudo", pseudo).getSingleResult();
		}
		catch(NonUniqueResultException e){
			logger.error(e);
		}
		catch(NoResultException nre) {
			logger.error(nre);
		}
		return null;
	}

}
