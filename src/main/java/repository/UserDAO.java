package repository;

import javax.persistence.EntityManager;
import entity.User;

public class UserDAO extends GenericDAO<User, Long> implements IUserDAO<User, Long> {

	public UserDAO(EntityManager em, Class<User> classParameter) {
		super(em, classParameter);
	}

}
