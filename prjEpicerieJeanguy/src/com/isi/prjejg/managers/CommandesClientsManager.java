package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.isi.prjejg.entites.CartProduit;
import com.isi.prjejg.entites.CommandeClient;
import com.isi.prjejg.services.ConnecteurBD;

public class CommandesClientsManager {

	private ConnecteurBD cbd;
	
	public CommandesClientsManager(ConnecteurBD cbd){
		this.cbd=cbd;
	}
	
	public ArrayList<CommandeClient> getAllCommandesClients(){
		return getAlCommandeClientsFromQuery("select * from commandesclients");
	}
	
	public ArrayList<CommandeClient> getAllCommandeClientsbyClientID(int ClientId){
		return getAlCommandeClientsFromQuery("select * from commandesclients WHERE noClient='"+ClientId+"'");
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
	
	public int addCommandeClient(int clientId, double totalCommande) {
		String sql="insert into commandesclients (totalCommande, noClient) values ('"+totalCommande+"','"+clientId+"')";
		PreparedStatement ps = cbd.getPreparedStatement(sql);
		int id=-1;
		try {
			ps.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			id = rs.getInt("GENERATED_KEY");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				cbd.fermerConnexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
}
