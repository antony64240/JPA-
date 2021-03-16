package ORM;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Groupeutilisateur;
import model.Utilisateur;

public class UtilisateurDAOImpl extends GenericDAOImpl<Utilisateur, Long> implements UtilisateurDAO {

//	@Override
	public Utilisateur getByEmail(String email) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();

		String sSql = "select u from Utilisateur u where email= :email";
		TypedQuery<Utilisateur> query = em.createQuery(sSql, Utilisateur.class);
		query.setParameter("email", email);

		Utilisateur user = null;
		user = query.getSingleResult();

		em.close();
		return user;
	}

	@Override
	public List<Utilisateur> getBetweenDate(String debut, String fin) {
		
		Timestamp Dfin = Timestamp.valueOf(fin);
		Timestamp deb = Timestamp.valueOf(debut);		
		
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();

		String sSql = "select u from Utilisateur u where creele BETWEEN :datedebut AND :datefin";
		TypedQuery<Utilisateur> query = em.createQuery(sSql, Utilisateur.class);
		query.setParameter("datedebut", deb);
		query.setParameter("datefin", Dfin);
		List<Utilisateur> user = null;
		user = query.getResultList();

		em.close();
		return user;
	}

	@Override
	public List<Utilisateur> getBetweenDate(String debut) {
		
		Timestamp Dfin = new Timestamp(Calendar.getInstance().getTime().getTime());
		
		Timestamp deb = Timestamp.valueOf(debut);		
		
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();

		String sSql = "select u from Utilisateur u where creele BETWEEN :datedebut AND :datefin";
		TypedQuery<Utilisateur> query = em.createQuery(sSql, Utilisateur.class);
		query.setParameter("datedebut", deb);
		query.setParameter("datefin", Dfin);
		List<Utilisateur> user = null;
		user = query.getResultList();

		em.close();
		return user;
	}
	
	
	public Utilisateur getById(Long id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();

		String sSql = "select u from Utilisateur u where id = :id";
		TypedQuery<Utilisateur> query = em.createQuery(sSql, Utilisateur.class);
		query.setParameter("id", id);

		Utilisateur user = null;
		user = query.getSingleResult();

		em.close();
		return user;
	}
	
	@Override
	public List<Utilisateur> getByGroupId(Long idGroup) {
		GroupeUtilisateurDAO dao = new GroupeUtilisateurDAOImpl();
		Groupeutilisateur groupestagiaire = dao.findById(idGroup);
		return groupestagiaire.getListUser();
	}


	
	

}
