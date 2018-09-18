package repository;

import entity.User;

public interface IUserDAO<T,PK> extends DAO<T,PK>{
	
	public User findByPseudo (String pseudo);
}
