package com.infotel.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.infotel.metier.Personne;
import com.infotel.metier.Voiture;

@Stateless
@LocalBean	//afin que la dao puisse etre accessible par le WS
public class DaoImpl implements IdaoLocal, IdaoRemote {

	@PersistenceContext(unitName = "pu_ejb_ws")
	EntityManager em;
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Ajouter +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public void addPersonne(Personne p) {
		// TODO Auto-generated method stub
		em.persist(p);
	}

	@Override
	public void addVoiture(Voiture v, long idPersonne) {
		// TODO Auto-generated method stub
		Personne p = em.find(Personne.class, idPersonne);
		v.setPersonne(p);
		em.persist(v);
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Supprimer +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public long supprimerPersonne(long idPersonne) {
		Query q = null;
		try {
			q = em.createQuery("DELETE FROM Personne p where p.id = :idp").setParameter("idp", idPersonne);
			idPersonne = q.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return idPersonne;
	}
	
	@Override
	public long supprimerVoiture(long idVoiture) {
		Query q = null;
		try {
			q = em.createQuery("DELETE FROM Voiture p where p.idVoiture = :idv").setParameter("idv", idVoiture);
			idVoiture = q.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return idVoiture;
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Modifier +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public void modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void modifierVoiture(Voiture v) {
		// TODO Auto-generated method stub
		em.merge(v);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Lecture +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public Personne getPersonne(long idPersonne) {
		// TODO Auto-generated method stub
		return em.find(Personne.class, idPersonne);
	}

	@Override
	public Voiture getVoiture(long idVoiture) {
		// TODO Auto-generated method stub
		return em.find(Voiture.class, idVoiture);
	}
		
	@Override
	public List<Personne> getAllPersonne() {
		// TODO Auto-generated method stub 
		return em.createQuery("SELECT p FROM Personne p").getResultList();
	}

	@Override
	public List<Voiture> getAllVoiture() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT v FROM Voiture v").getResultList();
	}

	@Override
	public List<Voiture> getVoitureParPersonne(long idPersonne) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT v FROM Voiture v WHERE v.personne.id = :idPersonne").setParameter("idPersonne", idPersonne).getResultList();
	}

	

}
