package com.infotel.dao;

import java.util.List;

import javax.ejb.Remote;

import com.infotel.metier.Personne;
import com.infotel.metier.Voiture;

@Remote
public interface IdaoRemote {

	public void addPersonne(Personne p);
	public void addVoiture(Voiture v, long idPersonne);
	
	public long supprimerPersonne(long idPersonne);
	public long supprimerVoiture(long idVoiture);
	
	public void modifierPersonne(Personne p);
	public void modifierVoiture(Voiture v);
	
	public Personne getPersonne(long idPersonne);
	public Voiture getVoiture(long idVoiture);
	
	public List<Personne> getAllPersonne();
	public List<Voiture> getAllVoiture();
	
	public List<Voiture> getVoitureParPersonne(long idPersonne);
}
