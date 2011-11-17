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
	
	public ProduitsManager(ConnecteurBD cbd) {
		this.cbd = cbd;
	}
	

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
			while(rs.next()){
				Produit p = new Produit(rs.getInt("noProduit"),
						rs.getString("descriptionProduit"),
						rs.getInt("qteProduit"), 
						rs.getString("formatProduit"),
						rs.getDouble("prixCoutant"),
						rs.getDouble("prixVendu"),
						rs.getInt("noCategorie")) ;
				alP.add(p);
				} 
			}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					ps.close();
					cbd.fermerConnexion();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return alP;
	}
}
