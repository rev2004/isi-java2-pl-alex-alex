package com.isi.prjejg.entites;

public class CartProduit {
	private int noProduit;
	private int qteProduitCommande;

	public CartProduit(int noProduit, int qteProduitCommande) {
		super();
		this.noProduit = noProduit;
		this.qteProduitCommande = qteProduitCommande;
	}

	public int getNoProduit() {
		return noProduit;
	}

	public void setNoProduit(int noProduit) {
		this.noProduit = noProduit;
	}

	public int getQteProduitCommande() {
		return qteProduitCommande;
	}

	public void setQteProduitCommande(int qteProduitCommande) {
		this.qteProduitCommande = qteProduitCommande;
	}

}
