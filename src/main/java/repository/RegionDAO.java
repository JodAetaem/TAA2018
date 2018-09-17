package repository;

import javax.persistence.EntityManager;

import entity.Region;

public class RegionDAO extends GenericDAO<Region, Long> implements IRegionDAO<Region, Long>{

	public RegionDAO(EntityManager em, Class<Region> classParameter) {
		super(em, classParameter);
	}

}
