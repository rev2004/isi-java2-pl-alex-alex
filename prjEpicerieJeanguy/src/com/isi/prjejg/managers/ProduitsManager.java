package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.isi.prjejg.entites.Categorie;
import com.isi.prjejg.entites.Produit;
import com.isi.prjejg.services.ConnecteurBD;

public class ProduitsManager {

	private ConnecteurBD cbd;
	

	public ArrayList<Produit> getAllProduits(){
		return getAlProduitFromQuery("select * from produits");
	}
	
	public ArrayList<Produit> getAllProduitsFromCatId(int CatId){
		return getAlProduitFromQuery("select * from produits where noCategorie='"+CatId+"'");
	}
	
	private ArrayList<Produit> getAlProduitFromQuery(String sql) {
		ArrayList<Produit> alP = new ArrayList<Produit>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ps= cbd.getPreparedStatement(sql);
		
		try {
			rs =ps.executeQuery();
			
		//parcourir le résultat
		while(rs.next()){
			//récupere le data
			
					
			Produit p = new Produit(rs.getInt("noProduit"),
					rs.getString("descriptionProduit"),
					rs.getInt("qteProduit"), 
					rs.getString("formatProduit"),
					rs.getDouble("prixcountant"),
					rs.getDouble("prixVendu"),
					rs.getInt("noCategorie")) ;
			alP.add(p);
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
		
		return alP;
	}
	
}
