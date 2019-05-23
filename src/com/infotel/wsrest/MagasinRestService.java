package com.infotel.wsrest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.infotel.dao.DaoImpl;
import com.infotel.metier.Magasin;
import com.infotel.metier.Personne;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;
import com.infotel.metier.Voiture;

@Stateless
@Path(value = "/magasins")
public class MagasinRestService {

	@EJB
	private DaoImpl dao;

	public DaoImpl getDao() {
		return dao;
	}

	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Supprimer +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GET
	@Path("supprProduitPeri/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public long supprimerProduitPerissable(
			@PathParam(value="idProduit") long idProduit) {
		
		return dao.supprimerProduitPerissable(idProduit);
	}
	@GET
	@Path("supprProduitNonPeri/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public long supprimerProduitNonPerissable(
			@PathParam(value="idProduit") long idProduit) {
		
		return dao.supprimerProduitNonPerissable(idProduit);
	}
	@GET
	@Path("supprMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public long supprimerMagasin(
			@PathParam(value="idMagasin") long idMagasin) {
		
		return dao.supprimerMagasin(idMagasin);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Lecture +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GET
	@Path("getProduitPerissable/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProduitPerissable getProduitPerissable(
			@PathParam(value="idProduit")long idProduit) {
		
		return dao.getProduitPerissable(idProduit);
	}
	@GET
	@Path("getProduitNonPerissable/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProduitNonPerissable getProduitNonPerissable(
			@PathParam(value="idProduit")long idProduit) {
		
		return dao.getProduitNonPerissable(idProduit);
	}
	
	@GET
	@Path("getMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Magasin getMagasin(
			@PathParam(value="idMagasin")long idMagasin) {
		
		return dao.getMagasin(idMagasin);
	}
	
	@GET
	@Path("allMagasins")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Magasin> getAllMagasin(){
		
		return dao.getAllMagasin();
	}
	
	@GET
	@Path("allVoitures")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Voiture> getAllVoitures(){
		
		return dao.getAllVoiture();
	}
	
	@GET
	@Path("VoituresParPersonne/{idPersonne}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Voiture> getVoitureParPersonne(
			@PathParam(value="idPersonne")long idPersonne){
		
		return dao.getVoitureParPersonne(idPersonne);
	}
}
