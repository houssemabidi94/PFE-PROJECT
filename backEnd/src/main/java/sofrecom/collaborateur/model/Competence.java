package sofrecom.collaborateur.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "competence")
public class Competence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(columnDefinition="TEXT")
	private String designation;
	
	@Column(columnDefinition="TEXT")
	private String definition;
	
	@Column(columnDefinition="TEXT")
	private String outilsEvaluation;
	
	@OneToMany(mappedBy="competence")
	private List<Description> descriptions;
	
	@OneToMany(mappedBy="competence")
	private List<Evaluation> evaluations;

	public Competence() {
		super();
	}
	
	

	public Competence(long id, String designation, String definition, String outilsEvaluation) {
		super();
		this.id = id;
		this.designation = designation;
		this.definition = definition;
		this.outilsEvaluation = outilsEvaluation;
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

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getOutilsEvaluation() {
		return outilsEvaluation;
	}

	public void setOutilsEvaluation(String outilsEvaluation) {
		this.outilsEvaluation = outilsEvaluation;
	}

	@Override
	public String toString() {
		return "Competence [id=" + id + ", designation=" + designation + ", definition=" + definition
				+ ", outilsEvaluation=" + outilsEvaluation + ", descriptions=" + descriptions + ", evaluations="
				+ evaluations + "]";
	}
	
}