package com.isi.rm.prjepiceriejeanguy.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.isi.rm.prjepiceriejeanguy.entites.Categorie;
import com.isi.rm.prjepiceriejeanguy.entites.Produits;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

public class ProduitsManager {

	private ConnecteurBD cbd;
	
	
public ArrayList<Produits> getAllProduits(){
	
	ArrayList<Produits> alP = new ArrayList<Produits>();
	String sql ="select * from produits";
	PreparedStatement ps=null;
	ResultSet rs=null;
	ps= cbd.getPreparedStatement(sql);
	
	try {
		rs =ps.executeQuery();
		
	//parcourir le résultat
	while(rs.next()){
		//récupere le data
		
				
		Produits p = new Produits(rs.getInt("noProduit"),
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
