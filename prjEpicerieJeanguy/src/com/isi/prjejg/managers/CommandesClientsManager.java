package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.isi.prjejg.entites.CommandeClient;
import com.isi.prjejg.services.ConnecteurBD;

public class CommandesClientsManager {

	private ConnecteurBD cbd;
	
	public ArrayList<CommandeClient> getAllCommandesClients(){
		
	return getAlCommandeClientsFromQuery("select * from clients cl  " +
				"INNER JOIN commandesclients cc " +
				"on cl.noClient = cc.noClient");
		
	}
	public ArrayList<CommandeClient> getAllCommandeClientsbyClientID(int ClientId){
	
		return getAlCommandeClientsFromQuery("select * from clients cl  " +
				"INNER JOIN commandesclients cc " +
				"on cl.noClient = cc.noClient Where cl.noClient='"+ClientId+"'");
		
		
	}
	
	private ArrayList<CommandeClient> getAlCommandeClientsFromQuery(String sql){
		ArrayList<CommandeClient> alCC = new ArrayList<CommandeClient>();
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ps=cbd.getPreparedStatement(sql);
		
		try {
			rs =ps.executeQuery();
			while(rs.next()){
				CommandeClient cc = new CommandeClient(rs.getInt("noCommande"),
								rs.getDouble("totalCommande"), 
								rs.getInt("noClient")) ;
				alCC.add(cc);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//fermer les objets
			try {
				rs.close();
				ps.close();
				cbd.fermerConnexion();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alCC;
	}
}
