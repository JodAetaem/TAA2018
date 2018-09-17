package repository;

import javax.persistence.EntityManager;

public class LieuDAO<Lieu,LieuId> extends GenericDAO<Lieu, LieuId> implements ILieuDAO<Lieu, LieuId> {

	public LieuDAO(EntityManager em, Class<Lieu> classParameter) {
		super(em, classParameter);
	}
}
