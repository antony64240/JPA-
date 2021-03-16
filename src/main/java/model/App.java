package model;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {

		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		// création d'une instance de la classe Stagiaire
		Utilisateur user = new Utilisateur();

		user.setLogin("Coadkdadaer");
		user.setMdp("joadec");
		user.setEmail("joe.cockdader@âudiens.fr");
		user.setUuid(UUID.randomUUID().toString());
		
		// enregistrement des données dans la base Postgresql
		em.merge(user);
	

		// fin de la transaction
		em.getTransaction().commit();
	}

}
