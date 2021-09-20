package sofrecom.collaborateur.model;

import java.util.Date;
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

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "entretien")
public class Entretien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = true)	
	private Date date;
	
	
	@Column(nullable = true)
	private Status status;
	
	@Column(nullable = true)
	private String projet;
	@Column(columnDefinition="TEXT")
	private String points;
	@Column(nullable = true)
	private String axes;
	@Column(nullable = true)
	private String formations;
	@Column(nullable = true)
	private String certifications;
	@Column(nullable = true)
	private String remarque;
	

	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
	private DAOUser user;
	
	@ManyToOne
    @JoinColumn(name = "idCampagne", referencedColumnName = "idCampagne")
	private Campagne campagne;

	@JsonIgnore
	@OneToMany(mappedBy = "entretien")
	private List<Objectif> objectifs;
	
	
	public Entretien() {
		super();
	}

	
	
	public Entretien(long id,DAOUser user, Campagne campagne) {
		super();
		this.id = id;
		this.user = user;
		this.campagne = campagne;
	}



	public Entretien(long id) {
		this.id = id;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getAxes() {
		return axes;
	}

	public void setAxes(String axes) {
		this.axes = axes;
	}


	public String getFormations() {
		return formations;
	}

	public void setFormations(String formations) {
		this.formations = formations;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public DAOUser getUser() {
		return user;
	}

	public void setUser(DAOUser user) {
		this.user = user;
	}

	public Campagne getCampagne() {
		return campagne;
	}

	public void setCampagne(Campagne campagne) {
		this.campagne = campagne;
	}

	public List<Objectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(List<Objectif> objectifs) {
		this.objectifs = objectifs;
	}
	
	public String getRemarque() {
		return remarque;
	}



	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	
}
