package com.isi.rm.prjepiceriejeanguy.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.isi.rm.prjepiceriejeanguy.entites.Categorie;
import com.isi.rm.prjepiceriejeanguy.services.ConnecteurBD;

public class CategorieManager  {

	private ConnecteurBD cbd;
	
	public CategorieManager(ConnecteurBD cbd) {
		
		this.cbd = cbd;
	}
	public ArrayList<Categorie> getAllCategories(){ 
	ArrayList<Categorie> alC= new ArrayList<Categorie>();
	String sql = "select * from categorie";
	PreparedStatement ps = null;
	ResultSet rs= null;
	
	ps=cbd.getPreparedStatement(sql);
	
	try {
		rs =ps.executeQuery();
		
	//parcourir le résultat
	while(rs.next()){
		//récupere le data
		
		Categorie c = new Categorie(rs.getInt("noCategorie"),rs.getString("descriptionCategorie"),rs.getString("image")) ;
		alC.add(c);
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
	
	return alC;
}


	
}
