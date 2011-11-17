package com.isi.prjejg.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.isi.prjejg.entites.Categorie;
import com.isi.prjejg.services.ConnecteurBD;

public class CategorieManager  {
	private ConnecteurBD cbd;
	
	public CategorieManager(ConnecteurBD cbd) {
		this.cbd = cbd;
	}
	
	public ArrayList<Categorie> getAllCategories(){ 
		ArrayList<Categorie> alC= new ArrayList<Categorie>();
		String sql = "select * from categories";
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		ps=cbd.getPreparedStatement(sql);
		
		try {
			rs =ps.executeQuery();
			while(rs.next()){
				Categorie c = new Categorie(rs.getInt("noCategorie"),rs.getString("descriptionCategorie"),rs.getString("image")) ;
				alC.add(c);
			}
		} catch (SQLException e) {
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
		return alC;
	}
}
