package com.isi.prjejg.entites;

public class CartProduit {
	private int noClient;
	private int noProduit;
	private int qteProduitCommande;
	private Produit p;

	public CartProduit(int noClient, int noProduit, int qteProduitCommande, Produit p) {
		super();
		this.noClient = noClient;
		this.noProduit = noProduit;
		this.qteProduitCommande = qteProduitCommande;
		this.p = p;
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

	public Produit getP() {
		return p;
	}

	public void setP(Produit p) {
		this.p = p;
	}

	public int getNoClient() {
		return noClient;
	}

	public void setNoClient(int noClient) {
		this.noClient = noClient;
	}

}
