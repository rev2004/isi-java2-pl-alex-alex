package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.isi.prjejg.entites.CartProduit;
import com.isi.prjejg.services.ConnecteurBD;

public class CartProduitManager {
	private ConnecteurBD cbd;
	
	public CartProduitManager(ConnecteurBD cbd) {
		this.cbd = cbd;
	}

	public ArrayList<CartProduit> getAlCartProduitsByClient(int ClientId){
		return getAlCartProduitsFromQuery("SELECT * FROM cartproduits WHERE noClient='"+ClientId+"'");
	}
	
	public ArrayList<CartProduit> getAlCartProduitsFromQuery(String sql){
		ArrayList<CartProduit> alCP= new ArrayList<CartProduit>();
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ps=cbd.getPreparedStatement(sql);
		
		try {
			rs =ps.executeQuery();
			
			while(rs.next()){
				CartProduit pc = new CartProduit(
						rs.getInt("noProduit"),
						rs.getInt("qteProduitCommande"));
				alCP.add(pc);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				cbd.fermerConnexion();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alCP;
	}
}
