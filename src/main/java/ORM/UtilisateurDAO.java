package ORM;



import java.sql.Timestamp;
import java.util.List;

import model.Utilisateur;

public interface UtilisateurDAO extends GenericDAO<Utilisateur, Long> {
	public Utilisateur getByEmail(String email);
	public List<Utilisateur> getBetweenDate(String debut, String fin);
	public List<Utilisateur> getBetweenDate(String debut);
	public Utilisateur getById(Long id);
	public List<Utilisateur> getByGroupId(Long idGroup);
}
