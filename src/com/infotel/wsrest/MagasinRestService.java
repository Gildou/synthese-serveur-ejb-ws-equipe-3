package com.infotel.wsrest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.infotel.dao.DaoImpl;

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
	@Path("supprPersonne/{idPersonne}")
	@Produces(MediaType.APPLICATION_JSON)
	public long supprimerPersonne(
			@PathParam(value="idPersonne") long id) {
		
		return dao.supprimerPersonne(id);
	}
	@GET
	@Path("supprVoiture/{idVoiture}")
	@Produces(MediaType.APPLICATION_JSON)
	public long supprimerVoiture(
			@PathParam(value="idVoiture") long idVoiture) {
		
		return dao.supprimerVoiture(idVoiture);
	}
}
