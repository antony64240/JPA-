package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the reponse database table.
 * 
 */
@Entity
@NamedQuery(name="Reponse.findAll", query="SELECT r FROM Reponse r")
public class Reponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="ReponseGenerator")
	@TableGenerator(name="ReponseGenerator",
    table="compteur",
    pkColumnName = "tablename",
    pkColumnValue = "reponse",
    valueColumnName = "nextid",
    allocationSize = 1
    )
	private Long id;

	private Integer bonne;

	private Timestamp creele;

	private String libelle;

	private Integer nombrepoints;

	private String texte;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="idquestion")
	private Question question;

	public Reponse() {
	}

	@Override
	public String toString() {
		return "Reponse [id=" + this.getId() + ", bonne=" + this.bonne + ", creele=" + creele + ", libelle=" + libelle
				+ ", nombrepoints=" + nombrepoints + ", texte=" + texte + ", question=" + question.getId() + "]";
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBonne() {
		return this.bonne;
	}

	public void setBonne(Integer bonne) {
		this.bonne = bonne;
	}

	public Timestamp getCreele() {
		return this.creele;
	}

	public void setCreele(Timestamp creele) {
		this.creele = creele;
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

	public String getTexte() {
		return this.texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}