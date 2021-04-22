package sofrecom.collaborateur.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
	@Column(nullable = true)
	private String points;
	@Column(nullable = true)
	private String axes;
	@Column(nullable = true)
	private String formations;
	@Column(nullable = true)
	private String certifications;
	
	
	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
	private DAOUser user;
	
	@ManyToOne
    @JoinColumn(name = "idCampagne", referencedColumnName = "idCampagne")
	private Campagne campagne;

	public Entretien() {
		super();
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

	@Override
	public String toString() {
		return "Entretien [id=" + id + ", date=" + date + ", status=" + status + ", projet=" + projet + ", points="
				+ points + ", axes=" + axes + ", formations=" + formations + ", certifications=" + certifications
				+ ", user=" + user + ", compagne=" + campagne + "]";
	}
	
}
