package sofrecom.collaborateur.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "campagne")
public class Campagne {

	@Id
	private String idCampagne;

	@Column(nullable = false)
	private Boolean actif;

	@OneToMany(mappedBy = "campagne")
	private List<Entretien> entretiens;

	public Campagne() {
		super();
	}

	public Campagne(String id, Boolean actif) {
		super();
		this.idCampagne = id;
		this.actif = actif;
	}

	public Campagne(String previousSemester) {
		this.idCampagne = previousSemester;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getIdCampagne() {
		return idCampagne;
	}

	public void setIdCampagne(String idCampagne) {
		this.idCampagne = idCampagne;
	}

}
