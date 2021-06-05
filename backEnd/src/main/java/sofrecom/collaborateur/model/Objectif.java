package sofrecom.collaborateur.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name = "objectif")
public class Objectif {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = true)
	private String designation;
	@Column(nullable = true)
	private String evaluation;
	@Column(nullable = true)
	private String commentaire;
	@Column(nullable = true)
	private String autoEvaluation;
	
	@Column(columnDefinition="TEXT")
	private String remarque;
	
	
	@ManyToOne()
    @JoinColumn(name = "idEntretien", referencedColumnName = "id")
	private Entretien entretien;
	
	
	public Objectif() {
		super();
	}
	

	public Objectif(String designation) {
		super();
		this.designation = designation;

	}

	public Objectif(long id,String designation,Entretien ent) {
		super();
		this.id = id;
		this.designation = designation;
		this.entretien = ent;

	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getEvaluation() {
		return evaluation;
	}
	
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public String getAutoEvaluation() {
		return autoEvaluation;
	}
	
	public void setAutoEvaluation(String autoEvaluation) {
		this.autoEvaluation = autoEvaluation;
	}


	public Entretien getEntretien() {
		return entretien;
	}


	public void setEntretien(Entretien entretien) {
		this.entretien = entretien;
	}


	public String getRemarque() {
		return remarque;
	}


	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	

	
	
}
