
import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.AfterClass;

import org.junit.Test;


import ORM.QuestionDAO;
import ORM.QuestionDAOImpl;
import ORM.UtilisateurDAO;
import ORM.UtilisateurDAOImpl;
import model.Question;
import model.Reponse;
import model.Utilisateur;

public class OrmTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

//	@Test
	public void listQuestion() {
		QuestionDAO dao = new QuestionDAOImpl();
		List<Question> liste = dao.findAll();
		for (Question quest : liste) {
			System.out.println(quest);
		}
		assert (true);
	}

//	@Test
	public void addQuestion() {
		QuestionDAO dao = new QuestionDAOImpl();
		Question quest = new Question();
		quest.setLibelle("Une classe abstraite peut-elle être étendu?");
		quest.setNombrepoints(10);
		quest.setTexteaide("Les classes abstraites ne peuvent pas utiliser de méthodes.");

		Reponse rep1 = new Reponse();
		rep1.setLibelle("Vrai");
		rep1.setTexte("addQuestion : text reponse1");
		rep1.setNombrepoints(0);
		rep1.setBonne(0);
		Reponse rep2 = new Reponse();
		rep2.setLibelle("Faux");
		rep2.setTexte("addQuestion : text reponse2");
		rep2.setBonne(1);
		rep2.setNombrepoints(10);

		quest.addRepons(rep2);
		quest.addRepons(rep1);

		dao.save(quest);

	}

//	@Test
	public void DeletQuestion() {
		QuestionDAO dao = new QuestionDAOImpl();
		Question quest = new Question();
		quest.setLibelle("Une classe abstraite peut-elle être implementer?");
		quest.setNombrepoints(10);
		quest.setTexteaide("Les classes abstraites ne peuvent pas utiliser de méthodes.");

		Reponse rep1 = new Reponse();
		rep1.setLibelle("Vrai");
		rep1.setTexte("addQuestion : text reponse1");
		rep1.setNombrepoints(0);
		rep1.setBonne(10);
		Reponse rep2 = new Reponse();
		rep2.setLibelle("Faux");
		rep2.setTexte("addQuestion : text reponse2");
		rep2.setBonne(1);
		rep2.setNombrepoints(0);

		quest.addRepons(rep2);
		quest.addRepons(rep1);

		Question questionASupprimer = dao.save(quest);
		dao.delete(questionASupprimer.getId());
		Question deletedQuestion = dao.findById(questionASupprimer.getId());
		assertTrue(deletedQuestion == null);

	}

//	@Test	
	public void AddUtilisateur() {
		UtilisateurDAO dao = new UtilisateurDAOImpl();
		Utilisateur user = new Utilisateur();
		user.setLogin("Coadkdadaer");
		user.setMdp("joadec");
		user.setEmail("joe.cockdader@audiens.fr");
		user.setUuid(UUID.randomUUID().toString());
		dao.save(user);
	}

//	@Test
	public void GetUserbyEmail() {
		UtilisateurDAO dao = new UtilisateurDAOImpl();
		Utilisateur user = dao.getByEmail("joe.cockdader@audiens.fr");
		System.out.println(user.toString());

	}
	
//	@Test
	public void GetUserbyId() {
		UtilisateurDAO dao = new UtilisateurDAOImpl();
		Utilisateur user = dao.getById((long) 1);
		System.out.println(user.toString());
	}
	
//	@Test
	public void GetUserByDate() {
		UtilisateurDAO dao = new UtilisateurDAOImpl();
		String date = "2018-08-12 00:00:00.000";
		List<Utilisateur> liste = dao.getBetweenDate(date);
		for (Utilisateur user : liste) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void getStagiairesByGroupId() {
		UtilisateurDAO dao = new UtilisateurDAOImpl();
		List<Utilisateur>liste = dao.getByGroupId((long) 3);
		System.out.println("------------------getStagiairesByGroupId-------------------");
		for(Utilisateur stagiaire : liste) {
			System.out.println(stagiaire);
		}	
	}
	

}
