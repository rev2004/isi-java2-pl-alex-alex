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
		ArrayList<CommandeClient> alPC= new ArrayList<CommandeClient>();
		String sql = "select * from CommandesClients";
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ps=cbd.getPreparedStatement(sql);
		
		try {
			rs =ps.executeQuery();
			
		//parcourir le résultat
		while(rs.next()){
			//récupere le data
			
			/*
			 * noCommande     bigint(20)  (NULL)     NO      PRI     (NULL)   auto_increment  select,insert,update,references         
			totalCommande  double      (NULL)     YES             (NULL)                   select,insert,update,references         
			noClient       bigint(20)  (NULL)     YES             (NULL)                   select,insert,update,references         

			 */
			
			CommandeClient pc = new CommandeClient(rs.getInt("noCommande"),
							rs.getDouble("totalCommande"), 
							rs.getInt("noClient")) ;
			alPC.add(pc);
			} 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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
		
		return alPC;
	}

	
	
}
