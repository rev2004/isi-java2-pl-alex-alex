package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.isi.prjejg.entites.Client;
import com.isi.prjejg.services.ConnecteurBD;

public class ClientManager {
	
	private ConnecteurBD cbd;
	
	public ClientManager(ConnecteurBD cbd){
		
		this.cbd=cbd;
	}
	
	public ArrayList<Client> getAllClients(){
		ArrayList<Client> alC= new ArrayList<Client>();
		String sql = "select * from Clients";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ps = cbd.getPreparedStatement(sql);
		try {
			rs = ps.executeQuery();
			
			while(rs.next()){
				/*private int noClient;
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
				 * 
				 * 
				 */
				
				Client c = new Client (rs.getInt("noClient"),
										rs.getString("nomClient"),
										rs.getString("prenomClient"),
										rs.getInt("NoCiviqueClient"),
										rs.getString("rueClient"),
										rs.getString("codePostalClient"),
										rs.getString("villeClient"),
										rs.getString("noCarteCredit"),
										rs.getString("telephoneClient"),
										rs.getString("courrielClient"),
										rs.getString("passwordClient"));
				alC.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return alC;	
	}
	
	public Client getLoginMembre(String username, String password){
		ArrayList<Client> alMembre = getAlClientsFromQuery("select * from clients where courrielClient='"+username+"' and passwordClient='"+password+"'");
		if(alMembre.size()>0)
			return alMembre.get(0);
		else
			return null;
	}
	
	private ArrayList<Client> getAlClientsFromQuery(String req){
		ArrayList<Client> alM = new ArrayList<Client>(); 
		PreparedStatement ps=null;
		ResultSet rs= null;
		ps= cbd.getPreparedStatement(req);
		
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Client m = new Client(rs.getInt("noClient"),
						rs.getString("nomClient"),
						rs.getString("prenomClient"),
						rs.getInt("NoCiviqueClient"),
						rs.getString("rueClient"),
						rs.getString("codePostalClient"),
						rs.getString("villeClient"),
						rs.getString("noCarteCredit"),
						rs.getString("telephoneClient"),
						rs.getString("courrielClient"),
						rs.getString("passwordClient"));
				alM.add(m);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				cbd.fermerConnexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return alM;
	}

}
