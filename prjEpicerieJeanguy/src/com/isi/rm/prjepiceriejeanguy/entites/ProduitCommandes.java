package com.isi.rm.prjepiceriejeanguy.entites;

public class ProduitCommandes {

	/*
	 * noProduit           bigint(20)    (NULL)             NO      PRI     (NULL)   auto_increment  select,insert,update,references         
descriptionProduit  varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
qteProduit          int(11)       (NULL)             YES             (NULL)                   select,insert,update,references         
formatProduit       varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
prixCoutant         double        (NULL)             YES             (NULL)                   select,insert,update,references         
prixVendu           double        (NULL)             YES             (NULL)                   select,insert,update,references         
noCategorie         bigint(20)    (NULL)             YES             (NULL)                   select,insert,update,references         
	 */
	
	private int noProduit;
	String descriptionProduit;
	private int qteProduit;
	String formatProduit;
	private double prixCountant;
	private double prixVendu;
	private int nocategorie;
	
	
	public ProduitCommandes(int noProduit, String descriptionProduit,
			int qteProduit, String formatProduit, double prixCountant,
			double prixVendu, int nocategorie) {
		super();
		this.noProduit = noProduit;
		this.descriptionProduit = descriptionProduit;
		this.qteProduit = qteProduit;
		this.formatProduit = formatProduit;
		this.prixCountant = prixCountant;
		this.prixVendu = prixVendu;
		this.nocategorie = nocategorie;
	}


	public int getNoProduit() {
		return noProduit;
	}


	public void setNoProduit(int noProduit) {
		this.noProduit = noProduit;
	}


	public String getDescriptionProduit() {
		return descriptionProduit;
	}


	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}


	public int getQteProduit() {
		return qteProduit;
	}


	public void setQteProduit(int qteProduit) {
		this.qteProduit = qteProduit;
	}


	public String getFormatProduit() {
		return formatProduit;
	}


	public void setFormatProduit(String formatProduit) {
		this.formatProduit = formatProduit;
	}


	public double getPrixCountant() {
		return prixCountant;
	}


	public void setPrixCountant(double prixCountant) {
		this.prixCountant = prixCountant;
	}


	public double getPrixVendu() {
		return prixVendu;
	}


	public void setPrixVendu(double prixVendu) {
		this.prixVendu = prixVendu;
	}


	public int getNocategorie() {
		return nocategorie;
	}


	public void setNocategorie(int nocategorie) {
		this.nocategorie = nocategorie;
	}
	
}
