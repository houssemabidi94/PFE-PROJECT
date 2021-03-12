package sofrecom.collaborateur.model;



import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;



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
	private String matirucule;
	@Column(nullable = true)
	@JsonFormat(pattern="dd/MM/yyyy")
	private SimpleDateFormat dateIntegration;

	
//	private DAOUser manager;
	
	@OneToMany(mappedBy="user")
	private List<Objectif> ojectifs;
	
	@OneToMany(mappedBy="user")
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatirucule() {
		return matirucule;
	}
	public void setMatirucule(String matirucule) {
		this.matirucule = matirucule;
	}
	public SimpleDateFormat getDateIntegration() {
		return dateIntegration;
	}

	public void setDateIntegration(SimpleDateFormat dateIntegration) {
		this.dateIntegration = dateIntegration;
	}

	public String getFullname() {
		return fullname;
	}

//	public DAOUser getManager() {
//		return manager;
//	}
//
//
//	public void setManager(DAOUser manager) {
//		this.manager = manager;
//	}


	

	
}