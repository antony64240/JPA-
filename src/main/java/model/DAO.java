package model;

import java.util.ArrayList;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;

import ORM.UtilisateurDAO;
import ORM.UtilisateurDAOImpl;

//-----------------------------------------------------
// Gestion de personnes en mémoire
// ajouter, lister, rechercher, supprimer, modifier
// -----------------------------------------------------
@Singleton
@Path("/personnes")
public class DAO {

	Gson g = new Gson();


	// Par postulat dans REST
	// GET seul => tout
	// GET + id => ne donne que la ressource identifiéee par id
	// POST + personne => Créer une personne
	// PUT + id + personne => modifier precisement cette ressource
	// DELETE + id => supprime precisement cette ressource

	// serialisation d'objet
//	@GET
//	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response liretout() {
//		
//		
//		
//		
//		return Response.status(200).entity(g.toJson(dao.GetUsers())).build();
//	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lire(@PathParam("id") int id) {
		System.out.println("im here");
		UtilisateurDAO dao = new UtilisateurDAOImpl();
		Utilisateur user = dao.getById((long) 1);

		return Response.status(200).entity(g.toJson(user)).build();
	}

//	@POST
//	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String ajouter(String data) {		
//		System.out.println(data);
//		Personne p = g.fromJson(data, Personne.class);
//		dao.addUser(p);
//		return "OK";
//	}
//	
//	
//	@PUT
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response Update(@PathParam("id") int id,String data) {
//		String result = dao.UpdateUser(g.fromJson(data, Personne.class));
//		return Response.status(200).entity(result).build();
//	}
	

}