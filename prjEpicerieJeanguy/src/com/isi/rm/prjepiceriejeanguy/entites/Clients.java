package com.isi.rm.prjepiceriejeanguy.entites;

public class Clients {
/*
noClient          bigint(20)    (NULL)             NO      PRI     (NULL)   auto_increment  select,insert,update,references         
nomClient         varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
prenomClient      varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
noCiviqueClient   int(11)       (NULL)             YES             (NULL)                   select,insert,update,references         
rueClient         varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
codePostalClient  varchar(10)   latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
villeClient       varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
noCarteCredit     varchar(30)   latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
telephoneClient   varchar(30)   latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
courrielClient    varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
passwordClient    varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
*/
	
private int noClient;
String nomClient;
String prenomClient;
private int noCiviqueClient;
String rueClient;
String codePostalClient;
String villeClient;
String noCarteCredit;
String telephoneClient;
String courrielClient;
String passwordClient;

public Clients(int noClient, String nomClient, String prenomClient, int noCiviqueClient, String rueClient, String codePostalClient,
		String villeClient, String noCarteCredit, String telephoneClient,
		String courrielClient, String passwordClient) {
	super();
	this.noClient = noClient;
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.noCiviqueClient = noCiviqueClient;
	this.rueClient = rueClient;
	this.codePostalClient = codePostalClient;
	this.villeClient = villeClient;
	this.noCarteCredit = noCarteCredit;
	this.telephoneClient = telephoneClient;
	this.courrielClient = courrielClient;
	this.passwordClient = passwordClient;
}
public int getNoClient() {
	return noClient;
}
public void setNoClient(int noClient) {
	this.noClient = noClient;
}
public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public String getPrenomClient() {
	return prenomClient;
}
public void setPrenomClient(String prenomClient) {
	this.prenomClient = prenomClient;
}
public int getNoCiviqueClient() {
	return noCiviqueClient;
}
public void setNoCiviqueClient(int noCiviqueClient) {
	this.noCiviqueClient = noCiviqueClient;
}
public String getRueClient() {
	return rueClient;
}
public void setRueClient(String rueClient) {
	this.rueClient = rueClient;
}
public String getCodePostalClient() {
	return codePostalClient;
}
public void setCodePostalClient(String codePostalClient) {
	this.codePostalClient = codePostalClient;
}
public String getVilleClient() {
	return villeClient;
}
public void setVilleClient(String villeClient) {
	this.villeClient = villeClient;
}
public String getNoCarteCredit() {
	return noCarteCredit;
}
public void setNoCarteCredit(String noCarteCredit) {
	this.noCarteCredit = noCarteCredit;
}
public String getTelephoneClient() {
	return telephoneClient;
}
public void setTelephoneClient(String telephoneClient) {
	this.telephoneClient = telephoneClient;
}
public String getCourrielClient() {
	return courrielClient;
}
public void setCourrielClient(String courrielClient) {
	this.courrielClient = courrielClient;
}
public String getPasswordClient() {
	return passwordClient;
}
public void setPasswordClient(String passwordClient) {
	this.passwordClient = passwordClient;
}


	
	
	
}
