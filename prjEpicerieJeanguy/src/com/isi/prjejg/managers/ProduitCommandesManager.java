package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.isi.prjejg.entites.ProduitCommande;
import com.isi.prjejg.services.ConnecteurBD;

public class ProduitCommandesManager {
	private ConnecteurBD cbd;
	
	public ProduitCommandesManager(ConnecteurBD cbd){
		
		this.cbd=cbd;
		
	}
	
	public ArrayList<ProduitCommande> getAllProduitCommandes(){
		ArrayList<ProduitCommande> alPC= new ArrayList<ProduitCommande>();
		String sql = "select * from produitscommandes";
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ps=cbd.getPreparedStatement(sql);
		
		try {
			rs =ps.executeQuery();
			
		//parcourir le résultat
		while(rs.next()){
			//récupere le data
			
			/*
			noProduit           bigint(20)    (NULL)             NO      PRI     (NULL)   auto_increment  select,insert,update,references         
			descriptionProduit  varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
			qteProduit          int(11)       (NULL)             YES             (NULL)                   select,insert,update,references         
			formatProduit       varchar(100)  latin1_swedish_ci  YES             (NULL)                   select,insert,update,references         
			prixCoutant         double        (NULL)             YES             (NULL)                   select,insert,update,references         
			prixVendu           double        (NULL)             YES             (NULL)                   select,insert,update,references         
			noCategorie         bigint(20)    (NULL)             YES             (NULL)                   select,insert,update,references         
				 */
			
			ProduitCommande pc = new ProduitCommande(rs.getInt("noProduit"),
							rs.getString("descriptionProduit"),
							rs.getInt("qteProduit"), 
							rs.getString("formatProduit"), 
							rs.getDouble("prixCoutant"), 
							rs.getDouble("prixVendu"), 
							rs.getInt("noCategorie")) ;
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
