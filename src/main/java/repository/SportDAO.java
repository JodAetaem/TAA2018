package repository;

import javax.persistence.EntityManager;
import entity.Sport;

public class SportDAO extends  GenericDAO< Sport, Long> implements ISportDAO<Sport, Long>{

	public SportDAO(EntityManager em, Class<Sport> classParameter) {
		super(em, Sport.class);
		
	}


	

}
