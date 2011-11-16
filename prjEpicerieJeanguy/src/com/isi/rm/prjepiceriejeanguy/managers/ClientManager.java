package com.isi.rm.prjepiceriejeanguy.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.isi.rm.prjepiceriejeanguy.entites.Clients;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

public class ClientManager {
	
	private ConnecteurBD cbd;
	
	public ClientManager(ConnecteurBD cbd){
		
		this.cbd=cbd;
	}
	
	public ArrayList<Clients> getAllClients(){
		ArrayList<Clients> alC= new ArrayList<Clients>();
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
				
				Clients c = new Clients (rs.getInt("noClient"),
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

}