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

	public CartProduit getCartProduitByClientProduit(int clientId, int produitId){
		ArrayList<CartProduit> alCP = getAlCartProduitsFromQuery("SELECT * FROM cartproduits WHERE noClient='"+clientId+"' AND noProduit='"+produitId+"'");
		if(alCP.size()>0)
			return alCP.get(0);
		return null;
	}
	
	public void addCartProduit(int clientId, int produitId) {
		CartProduit cp = getCartProduitByClientProduit(clientId, produitId);
		if(cp == null) {
			updateCartProduitQuery("insert into cartproduits (noClient, noProduit, qteProduitCommande) values ('"+clientId+"','"+produitId+"','1')");
		} else {
			updateCartProduitQuery("update cartproduits set qteProduitCommande='"+(cp.getQteProduitCommande()+1)+"' WHERE noClient='"+clientId+"' AND noProduit='"+produitId+"'");
		}
	}
	
	public void removeCartProduit(int clientId, int produitId) {
		CartProduit cp = getCartProduitByClientProduit(clientId, produitId);
		if(cp != null) {
			updateCartProduitQuery("DELETE FROM cartproduits WHERE noClient='"+clientId+"' AND noProduit='"+produitId+"'");
		}
	}
	
	private void updateCartProduitQuery(String sql) {
		PreparedStatement ps = cbd.getPreparedStatement(sql);
		try {
			ps.executeUpdate(sql);
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
	}
	
	public ArrayList<CartProduit> getAlCartProduitsFromQuery(String sql){
		ArrayList<CartProduit> alCP= new ArrayList<CartProduit>();
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ps=cbd.getPreparedStatement(sql);
		
		try {
			rs=ps.executeQuery(); 
			while(rs.next()){
				CartProduit pc = new CartProduit(
						rs.getInt("noProduit"),
						rs.getInt("qteProduitCommande"),
						null);
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
		ProduitsManager pm = new ProduitsManager(cbd);
		for(CartProduit cp : alCP)
			cp.setP(pm.getProduitById(cp.getNoProduit()));
		return alCP;
	}
}
