package sofrecom.collaborateur.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fonction")
public class Fonction {

	@Id
	private long id;
	
	@Column(nullable = false)
	private String libelle;
	
	@OneToMany(mappedBy = "fonction")
	@JsonIgnore
	private Set<DAOUser> users;

	
	
	public Fonction() {
		super();
	}

	public Fonction(long id,String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public Fonction(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<DAOUser> getUsers() {
		return users;
	}

	public void setUsers(Set<DAOUser> users) {
		this.users = users;
	}
	
	
}
