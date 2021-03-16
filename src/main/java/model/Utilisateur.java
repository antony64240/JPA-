package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;




/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="UtilisateurGenerator")
	// select tablename, nextid from compteur where tablename = 'stagiaire';
	@TableGenerator(name="UtilisateurGenerator",
	                table="compteur",
	                pkColumnName = "tablename",
	                pkColumnValue = "utilisateur",
	                valueColumnName = "nextid",
	                allocationSize = 1
	                )
	private Long id;

	@Column(insertable = false)
	private Timestamp creele;

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", creele=" + creele + ", email=" + email + ", login=" + login + ", mdp=" + mdp
				+ ", uuid=" + uuid + "]";
	}

	private String email;

	private String login;

	private String mdp;

	private String uuid;

	public Utilisateur() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getUuid() {
		return this.uuid;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(id, other.id);
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}