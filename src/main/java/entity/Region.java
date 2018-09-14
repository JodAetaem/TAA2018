package entity;

import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Region {
	
	private long id;
	private long code;
	private String name;
	
	private Set<Lieu> lieux;
	private Set<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	public Set<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(Set<Lieu> lieux) {
		this.lieux = lieux;
	}

	@ManyToMany
	@JoinTable(
			name="region_user",
			joinColumns=@JoinColumn(name="region_id"),
			inverseJoinColumns=@JoinColumn(name = "user_id")
			)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	

}
