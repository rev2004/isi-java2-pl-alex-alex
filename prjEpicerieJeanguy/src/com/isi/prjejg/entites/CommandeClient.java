package com.isi.prjejg.entites;

public class CommandeClient {
/*
 * noCommande     bigint(20)  (NULL)     NO      PRI     (NULL)   auto_increment  select,insert,update,references         
totalCommande  double      (NULL)     YES             (NULL)                   select,insert,update,references         
noClient       bigint(20)  (NULL)     YES             (NULL)                   select,insert,update,references         

 */
	
private int noCommande;
private double totalCommande;
private int noClient;
public CommandeClient(int noCommande, double totalCommande, int noClient) {
	super();
	this.noCommande = noCommande;
	this.totalCommande = totalCommande;
	this.noClient = noClient;
}
public int getNoCommande() {
	return noCommande;
}
public void setNoCommande(int noCommande) {
	this.noCommande = noCommande;
}
public double getTotalCommande() {
	return totalCommande;
}
public void setTotalCommande(double totalCommande) {
	this.totalCommande = totalCommande;
}
public int getNoClient() {
	return noClient;
}
public void setNoClient(int noClient) {
	this.noClient = noClient;
}
	
	
}
