package com.isi.prjejg.entites;

public class Produit {
/*noProduit           bigint(20)    (NULL)             NO      PRI     (NULL)   auto_increment  select,insert,update,references         
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
	private double prixCoutant;
	private double prixVendu;
	private int noCategorie;
	
	
	public Produit(int noProduit, String descriptionProduit, int qteProduit,
			String formatProduit, double prixCoutant, double prixVendu,
			int noCategorie) {
		super();
		this.noProduit = noProduit;
		this.descriptionProduit = descriptionProduit;
		this.qteProduit = qteProduit;
		this.formatProduit = formatProduit;
		this.prixCoutant = prixCoutant;
		this.prixVendu = prixVendu;
		this.noCategorie = noCategorie;
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


	public double getPrixCoutant() {
		return prixCoutant;
	}


	public void setPrixCoutant(double prixCoutant) {
		this.prixCoutant = prixCoutant;
	}


	public double getPrixVendu() {
		return prixVendu;
	}


	public void setPrixVendu(double prixVendu) {
		this.prixVendu = prixVendu;
	}


	public int getNoCategorie() {
		return noCategorie;
	}


	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	
}
