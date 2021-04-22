package sofrecom.collaborateur.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = true)
	private String fullname;
	@Column(nullable = true)
	private String email;
	@Column(nullable = true)
	private String username;
	@Column
//	@JsonIgnore
	private String password;
	@Column(nullable = true)
	private String matricule;
	@Column(nullable = true)
	private Date dateIntegration;
	@Column(nullable = true)
	private long manager_id;

	@OneToMany(mappedBy = "user")
	private List<Objectif> ojectifs;

	@OneToMany(mappedBy = "user")
	private List<Entretien> entretiens;

	@ManyToOne
	@JoinColumn(name = "idFonction", referencedColumnName = "id")
	private Fonction fonction;

	@ManyToOne
	@JoinColumn(name = "idDirection", referencedColumnName = "id")
	private Direction direction;

	public DAOUser() {
		super();
	}

	public DAOUser(String fullname) {
		super();
		this.fullname = fullname;
	}

	public long getId() {
		return id;
	}

	public String getFullnamee() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getDateIntegration() {
		return dateIntegration;
	}

	public void setDateIntegration(Date dateIntegration) {
		this.dateIntegration = dateIntegration;
	}

	public String getFullname() {
		return fullname;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public long getManager_id() {
		return manager_id;
	}

	public void setManager_id(long manager_id) {
		this.manager_id = manager_id;
	}


}