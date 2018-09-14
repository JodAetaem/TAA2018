package entity;

import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Lieu {

	
	private LieuId id;
		
	private Set<Sport> sports;
	
	private Region region;
	
	@EmbeddedId
	public LieuId getId() {
		return id;
	}

	public void setId(LieuId id) {
		this.id = id;
	}

	@ManyToMany
	@JoinTable(name="lieu_sport",
			   joinColumns= @JoinColumn(name = "lieu_id"),
			   inverseJoinColumns=@JoinColumn(name="sport_id"))
	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}

	@ManyToOne
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	

	
	
	
}
