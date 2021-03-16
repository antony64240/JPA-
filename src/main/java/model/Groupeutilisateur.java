package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the groupeutilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Groupeutilisateur.findAll", query="SELECT g FROM Groupeutilisateur g")
public class Groupeutilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Timestamp creele;

	private String nom;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="utilisateur_groupe",
			joinColumns =@JoinColumn(name="groupeutilisateurid"),
			inverseJoinColumns = @JoinColumn(name="utilisateurid"))	
	private List<Utilisateur> utilisateurList;
	
	
	
	public Groupeutilisateur() {
		utilisateurList= new ArrayList<Utilisateur>();
	}
	
	public List<Utilisateur> getListUser(){
		return this.utilisateurList;
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

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}