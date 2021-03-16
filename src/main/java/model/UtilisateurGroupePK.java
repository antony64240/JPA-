package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the utilisateur_groupe database table.
 * 
 */
@Embeddable
public class UtilisateurGroupePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Long utilisateurid;

	private Long groupeutilisateurid;

	public UtilisateurGroupePK() {
	}
	public Long getUtilisateurid() {
		return this.utilisateurid;
	}
	public void setUtilisateurid(Long utilisateurid) {
		this.utilisateurid = utilisateurid;
	}
	public Long getGroupeutilisateurid() {
		return this.groupeutilisateurid;
	}
	public void setGroupeutilisateurid(Long groupeutilisateurid) {
		this.groupeutilisateurid = groupeutilisateurid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UtilisateurGroupePK)) {
			return false;
		}
		UtilisateurGroupePK castOther = (UtilisateurGroupePK)other;
		return 
			this.utilisateurid.equals(castOther.utilisateurid)
			&& this.groupeutilisateurid.equals(castOther.groupeutilisateurid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.utilisateurid.hashCode();
		hash = hash * prime + this.groupeutilisateurid.hashCode();
		
		return hash;
	}
}