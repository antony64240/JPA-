package model;
import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="QuestionGenerator")
	@TableGenerator(name="QuestionGenerator",
    table="compteur",
    pkColumnName = "tablename",
    pkColumnValue = "question",
    valueColumnName = "nextid",
    allocationSize = 1
    )
	private Long id;

	private Timestamp creele;

	private String image;

	private String libelle;

	private Integer nombrepoints;

	private String texteaide;

	@OneToMany(mappedBy="question",cascade = {CascadeType.PERSIST,CascadeType.REMOVE} , fetch = FetchType.EAGER)
	private List<Reponse> reponses;

	public Question() {
		reponses = new ArrayList<Reponse>();
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", creele=" + creele + ", image=" + image + ", libelle=" + libelle
				+ ", nombrepoints=" + nombrepoints + ", texteaide=" + texteaide + ", reponses=" + reponses + "]";
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreele() {
		return this.creele;
	}

	public void setCreele(Timestamp creele) {
		this.creele = creele;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getNombrepoints() {
		return this.nombrepoints;
	}

	public void setNombrepoints(Integer nombrepoints) {
		this.nombrepoints = nombrepoints;
	}

	public String getTexteaide() {
		return this.texteaide;
	}

	public void setTexteaide(String texteaide) {
		this.texteaide = texteaide;
	}

	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse addRepons(Reponse repons) {
		getReponses().add(repons);
		repons.setQuestion(this);

		return repons;
	}

	public Reponse removeRepons(Reponse repons) {
		getReponses().remove(repons);
		repons.setQuestion(null);

		return repons;
	}

}