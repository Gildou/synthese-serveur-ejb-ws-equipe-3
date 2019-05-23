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
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;

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
	public void supprimerMagasin(
			@PathParam(value="idMagasin") long idMagasin) {
		
		Magasin m = new Magasin();
		//m.setIdMagasin(idMagasin);
		m = dao.getMagasin(idMagasin);
		dao.supprimerMagasin(m);
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
	@Path("allProduits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getAllProduits(){
		
		return dao.getAllProduit();
	}
	@GET
	@Path("allProduitsNonPerissables")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProduitNonPerissable> getAllProduitsNonPerissables(){
		
		return dao.getAllProduitNonPerissable();
	}
	@GET
	@Path("allProduitsPerissables")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProduitPerissable> getAllProduitsPerissables(){
		
		return dao.getAllProduitPerissable();
	}
	
	@GET
	@Path("ProduitsParMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getProduitsParMagasin(
			@PathParam(value="idMagasin")long idMagasin){
		
		return dao.getProduitParMagasin(idMagasin);
	}
}
