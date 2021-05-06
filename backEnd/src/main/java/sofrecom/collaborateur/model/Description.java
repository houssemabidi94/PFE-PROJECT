package sofrecom.collaborateur.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "description")
public class Description implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DescriptionPK descriptionPK = new DescriptionPK();
	
	@ManyToOne
    @JoinColumn(insertable=false,updatable=false, name = "idCompetence", referencedColumnName = "id")
	private Competence competence;

	@ManyToOne
    @JoinColumn(insertable=false,updatable=false, name = "idNiveau", referencedColumnName = "id")
	private Niveau niveau;	
	/////////
	@Column(columnDefinition="TEXT")
	String description;
	
	

	public Description() {
		super();
	}





	public Description(DescriptionPK descriptionPK, Competence competence, Niveau niveau, String description) {
		super();
		this.descriptionPK = descriptionPK;
		this.competence = competence;
		this.niveau = niveau;
		this.description = description;
	}





	public DescriptionPK getDescriptionPK() {
		return descriptionPK;
	}

	public void setDescriptionPK(DescriptionPK descriptionPK) {
		this.descriptionPK = descriptionPK;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Description [descriptionPK=" + descriptionPK + ", competence=" + competence + ", niveau=" + niveau
				+ ", description=" + description + "]";
	}
	

}
