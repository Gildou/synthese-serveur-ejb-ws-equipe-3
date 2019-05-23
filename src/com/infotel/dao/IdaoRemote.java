package com.infotel.dao;

import java.util.List;

import javax.ejb.Remote;

import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;


@Remote
public interface IdaoRemote {

	public void addMagasin(Magasin m);
	public void ajouterProduitNonPerissable(ProduitNonPerissable pnp, long idMagasin);
	public void ajouterProduitPerissable(ProduitPerissable pp, long idMagasin);
	
	public void supprimerMagasin(Magasin m);
	public long supprimerProduitNonPerissable(long idProduit);
	public long supprimerProduitPerissable(long idProduit);
	
	public void modifierMagasin(Magasin m);
	public void modifierProduitNonPerissable(ProduitNonPerissable pnp);
	public void modifierProduitPerissable(ProduitPerissable pp);
	
	public Magasin getMagasin(long idMagasin);
	public Produit getProduitNonPerissable(long idProduit);
	public Produit getProduitPerissable(long idProduit);
	
	public List<Magasin> getAllMagasin();
	public List<Produit> getAllProduit();
	public List<ProduitNonPerissable> getAllProduitNonPerissable();
	public List<ProduitPerissable> getAllProduitPerissable();
	
	public List<Produit> getProduitParMagasin(long idMagasin);
	public double calculPrixMagasin(Magasin m);
}