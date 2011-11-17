package com.isi.prjejg.entites;

public class Categorie {


/*
noCategorie           bigint(20)    (NULL)             NO      PRI     (NULL)   auto_increment  select,insert,update,references         
descriptionCategorie  varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
image                 varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
*/
	
private int noCategorie;
private String descriptionCategorie;
private String image;

public Categorie(int noCategorie,String descriptionCategorie, String image) {
		super();
		this.noCategorie = noCategorie;
		this.descriptionCategorie = descriptionCategorie;
		this.image = image;
	}


public int getNoCategorie() {
	return noCategorie;
}

public void setNoCategorie(int noCategorie) {
	this.noCategorie = noCategorie;
}

public String getDescriptionCategorie() {
	return descriptionCategorie;
}

public void setDescriptionCategorie(String descriptionCategorie) {
	this.descriptionCategorie = descriptionCategorie;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}




}
