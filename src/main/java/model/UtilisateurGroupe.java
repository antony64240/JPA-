package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the utilisateur_groupe database table.
 * 
 */
@Entity
@Table(name="utilisateur_groupe")
@NamedQuery(name="UtilisateurGroupe.findAll", query="SELECT u FROM UtilisateurGroupe u")
public class UtilisateurGroupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UtilisateurGroupePK id;

	private Timestamp creele;

	public UtilisateurGroupe() {
	}

	public UtilisateurGroupePK getId() {
		return this.id;
	}

	public void setId(UtilisateurGroupePK id) {
		this.id = id;
	}

	public Timestamp getCreele() {
		return this.creele;
	}

	public void setCreele(Timestamp creele) {
		this.creele = creele;
	}

}