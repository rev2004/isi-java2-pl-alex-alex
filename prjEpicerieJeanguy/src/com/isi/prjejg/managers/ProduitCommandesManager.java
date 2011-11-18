package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.isi.prjejg.entites.CartProduit;
import com.isi.prjejg.entites.ProduitCommande;
import com.isi.prjejg.services.ConnecteurBD;

public class ProduitCommandesManager {
	private ConnecteurBD cbd;
	
	public ProduitCommandesManager(ConnecteurBD cbd){
		this.cbd=cbd;
	}
	
	public ArrayList<ProduitCommande> getAllProduitCommandes(){
		return getAlProduitFromQuery("select * from produitscommandes");
	}
	
	public void addCartToCommande(CartProduit cp, int noCommande) {
		updateProduitCommandeQuery("insert into produitscommandes (noProduit, noCommande, qteProduitCommande, prixPaye) values ('"+cp.getNoProduit()+"','"+noCommande+"','"+cp.getQteProduitCommande()+"', '"+cp.getP().getPrixVendu()+"')");
	}
	
	private void updateProduitCommandeQuery(String sql) {
		PreparedStatement ps = cbd.getPreparedStatement(sql);
		int id=-1;
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
	
	public ArrayList<ProduitCommande> getAlProduitFromQuery(String sql){
		ArrayList<ProduitCommande> alPC= new ArrayList<ProduitCommande>();
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ps=cbd.getPreparedStatement(sql);
		
		try {
			rs =ps.executeQuery();
			while(rs.next()){
				ProduitCommande pc = new ProduitCommande(rs.getInt("noProduit"),
								rs.getString("descriptionProduit"),
								rs.getInt("qteProduit"), 
								rs.getString("formatProduit"), 
								rs.getDouble("prixCoutant"), 
								rs.getDouble("prixVendu"), 
								rs.getInt("noCategorie")) ;
				alPC.add(pc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				cbd.fermerConnexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alPC;
	}

}
