package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class GenericDAO<T,PK> implements DAO<T,PK>{
	
	@PersistenceContext(unitName="dev", type = PersistenceContextType.EXTENDED)
	EntityManager em;
	final Class<T> typeParmeterClass;
	
	public GenericDAO(EntityManager em, Class<T> classParameter) {
		this.em = em;
		typeParmeterClass = classParameter;
			
	}
	
	public T create( T t ){
		EntityTransaction tx = em.getTransaction();
		
		try{
			
			tx.begin();
			em.persist(t);
			tx.commit();
			
		}
		catch( Exception e )
		{
			tx.rollback();
		}
		return t;
	}
	
	public void update( T t ){
		
		EntityTransaction tx = em.getTransaction( );
		try{
			tx.begin();
			em.merge( t );
			tx.commit();
		}
		catch( Exception e )
		{
			tx.rollback();
		}
	}
	
	public void remove( T t ){
		EntityTransaction tx = em.getTransaction( );
		try{
			tx.begin();
			em.remove( t );
			tx.commit();
		}
		catch( Exception e )
		{
			tx.rollback( );
		}
	}
	
	public T findByPrimaryKey( PK pk ){
		return em.find( typeParmeterClass, pk);
	}

}
