package repository;

/**
 * 
 * DAO Interface
 *
 */
public interface DAO <T,PK> {

	T create( T t );
	
	void remove( T t );
	
	T findByPrimaryKey( PK pk);
	
	void update( T t );

	
}
